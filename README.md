Android-Pushbullet
==================

This is a simple Android library which uses Pushbullet API to push messages to Pushbullet enable device such as your smartphone or Chrome.

<h3><b>Set Up</b></h3>

Download .aar from https://mega.co.nz/#!Bot3DTJI!kz-AIZXOA2f7-qv46I2EN3VDQfp-XjyV8MGbT5F6VUU

Place it in your app module's libs directory (Eg:\AndroidStudioProjects\MyApplication\app\libs)

Go to module's build.gradle and add the following; 
```
repositories {
    flatDir {
        dirs 'libs'
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile(name:'android-pushbullet', ext:'aar')
}
```

Declare permission for Internet in AndroidManifest.xml;
```
<uses-permission android:name="android.permission.INTERNET"/>
```

<h3><b>Things You Need</b></h3>

As prerequisites you'll have to get your Pushbullet account's access token and id of the device you're pushing to.

Access Token: https://www.pushbullet.com/account

Get your device id by going to https://www.pushbullet.com/ , clicking on the device you want to push to and copying the device_iden string in the URL which must be something like "tHbTmqR4c8qfjs5gKoLDaK".

<h3><b>Usage</b></h3>

This library is still in development so only has the ability to push a note which I guess is sufficient for most cases. Use the following code to send a push whenever you need.

```
PushbulletClient pushbulletClient = new PushbulletClient(accessToken);
pushbulletClient.sendNote(deviceId,Title,Message);
```

Hoping to bring more features soon. Enjoy!




