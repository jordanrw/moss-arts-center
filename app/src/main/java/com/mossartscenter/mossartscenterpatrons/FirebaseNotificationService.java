package com.mossartscenter.mossartscenterpatrons;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by sudowoodo on 4/28/17.
 */

public class FirebaseNotificationService extends FirebaseMessagingService {

    private static final String TAG = "MACFirebaseMessagingService";

    /**
     * Called when a message is pushed from the Firebase console.
     *
     * @param remoteMessage The remote message from firebase
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Map<String, String> data = remoteMessage.getData();
        String icon = data.get("icon");


        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ticket)
               // .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ticket))
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setColor(getResources().getColor(R.color.colorAccent))
                .setStyle(new NotificationCompat.BigTextStyle())
                .setSound(defaultSoundUri);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
        //displayNotification(body, title);
    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();

    }
}

