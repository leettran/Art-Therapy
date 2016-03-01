package com.ngaini.arttherpy;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Nathan on 2/25/2016.
 */
public class BroadcastThis extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
//        boolean isScreenOn = powerManager.isScreenOn();
        KeyguardManager keyguardManager = (KeyguardManager)context.getSystemService(Context.KEYGUARD_SERVICE);
        if (keyguardManager.inKeyguardRestrictedInputMode())
        {
//
//            //phone was unlocked, do stuff here
            Toast.makeText(context, "We are here", Toast.LENGTH_SHORT).show();
//
        }
        else
        {
            Toast.makeText(context, "Broadcast Reciever working", Toast.LENGTH_SHORT).show();
            int id = 12345;
            int requestCode = 0;
            int flags = 0;
            intent.setClass(context,MainActivity.class);

            Intent callMain = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    context, requestCode, callMain, flags);

            Notification notification = new Notification.Builder(context)
                    .setContentTitle("Art Therapy")
                    .setContentText("Click to play Art Therapy")
                    .setSmallIcon(android.R.drawable.ic_menu_day)
                    .setContentIntent(pendingIntent)
                    .build();

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(
                    Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id, notification);


//            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(
//                    context).setSmallIcon(android.R.drawable.ic_menu_day)
//                    .setContentTitle("Test Notification")
//                    .setContentText("This is test notification ");
//            Intent myIntent = new Intent(context, MainActivity.class);
//            PendingIntent intent2 = PendingIntent.getBroadcast(context, 1,
//                    myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//            notificationBuilder.setContentIntent(intent2);
//            NotificationManager mNotificationManager = (NotificationManager) context
//                    .getSystemService(Context.NOTIFICATION_SERVICE);
//
//            mNotificationManager.notify(1, notificationBuilder.build());



//            Intent resultIntent = new Intent(context, MainActivity.class);
//            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//            stackBuilder.addParentStack(MainActivity.class);
//
//            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
//            mBuilder.setSmallIcon(android.R.drawable.ic_menu_day);
//            mBuilder.setContentTitle("Notification Alert, Click Me!");
//            mBuilder.setContentText("Hi, This is Android Notification Detail!");
//// Adds the Intent that starts the Activity to the top of the stack
//            stackBuilder.addNextIntent(resultIntent);
//            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
//            mBuilder.setContentIntent(resultPendingIntent);
//            NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
//            notificationManager.notify(id, notification);
//            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//
//// notificationID allows you to update the notification later on.
//            mNotificationManager.notify(id, mBuilder.build());

        }
    }
}
