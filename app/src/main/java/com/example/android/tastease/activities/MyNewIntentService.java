package com.example.android.tastease.activities;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.android.tastease.R;

public class MyNewIntentService extends IntentService {
    private static final int NOTIFICATION_ID = 0;
    NotificationCompat.Builder notification_builder;
    String username;
    public MyNewIntentService() {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.e(MyReceiver.class.getSimpleName(),"Entered MyNewIntentService");
   NotificationManager notification_manager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String chanel_id = "3000";
            CharSequence name = "Channel Name";
            String description = "Chanel Description";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(chanel_id, name, importance);
            mChannel.setDescription(description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.BLUE);
            notification_manager.createNotificationChannel(mChannel);
            notification_builder = new NotificationCompat.Builder(this, chanel_id);
        } else {
            notification_builder = new NotificationCompat.Builder(this);
        }
        Intent notifyIntent = new Intent(this, RandomFoodActivity.class);
       PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
       loadInfo();
        notification_builder.setSmallIcon(R.mipmap.icon)
                .setContentTitle("Tastease")
                .setContentText("Hey "+username+". Check out the recipe of the day!We are sure you would love it :)")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
        notification_manager.notify(3000, notification_builder.build());

    }
    private void loadInfo() {
        SharedPreferences sharedpref = getSharedPreferences("userdetails", MODE_PRIVATE);
        username=sharedpref.getString("Username","User");


    }
}