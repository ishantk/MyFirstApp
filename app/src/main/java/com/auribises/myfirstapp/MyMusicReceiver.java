package com.auribises.myfirstapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyMusicReceiver extends BroadcastReceiver {

    Context cxt;

    @Override
    public void onReceive(Context context, Intent intent) {

        cxt = context;

        String action = intent.getAction();

        if(action.equals("a.b.c.d")){


            // Whatever you wish to do

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setContentTitle("This is Title");
            builder.setContentText("This is Text");
            builder.setSmallIcon(R.drawable.music); // This is Mandatory
            builder.setDefaults(Notification.DEFAULT_ALL); // Vibrate Permission is required


            Intent allSongsIntent = new Intent(context,AllSongsActivity.class);
            PendingIntent pi = PendingIntent.getActivity(context,100,allSongsIntent,PendingIntent.FLAG_UPDATE_CURRENT);

            builder.setContentIntent(pi);

           // builder.setStyle(new NotificationCompat.BigTextStyle().bigText("This is Awesome"));
           // builder.addAction(android.R.drawable.ic_menu_add,"Add",pi);
           // builder.addAction(android.R.drawable.ic_delete,"Delete",pi);

            Notification notification = builder.build();


            notificationManager.notify(101,notification);
        }

        if(action.equals(Intent.ACTION_BATTERY_LOW)){
            Toast.makeText(context,"Battery seems to be low",Toast.LENGTH_LONG).show();
        }
    }
}
