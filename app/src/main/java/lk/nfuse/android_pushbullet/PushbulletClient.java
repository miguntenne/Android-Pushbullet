package lk.nfuse.android_pushbullet;

import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chomal on 10/17/2014.
 */
public class PushbulletClient {

    private DefaultHttpClient defaultHttpClient;
    private CredentialsProvider credentialsProvider;

    public static final String URL = "https://api.pushbullet.com/v2/pushes";

    public PushbulletClient(String accessToken) {

        credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(accessToken, null));
    }

    public void sendNote(String deviceId, String title, String body) {
        defaultHttpClient = new DefaultHttpClient();
        defaultHttpClient.setCredentialsProvider(credentialsProvider);

        HttpPost post = new HttpPost(URL);

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("type", "note"));
            nameValuePairs.add(new BasicNameValuePair("device_iden", deviceId));
            nameValuePairs.add(new BasicNameValuePair("title", title));
            nameValuePairs.add(new BasicNameValuePair("body", body));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            defaultHttpClient.execute(post);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
