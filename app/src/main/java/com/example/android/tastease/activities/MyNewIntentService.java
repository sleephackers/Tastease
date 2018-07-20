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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tastease.R;
import com.example.android.tastease.RetrofitCalls.ApiClient;
import com.example.android.tastease.RetrofitCalls.ApiInterface;
import com.example.android.tastease.randomfood.randomBody;
import com.example.android.tastease.recipeinfo.RecipeInformation;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyNewIntentService extends IntentService {
    private static final int NOTIFICATION_ID = 0;
    NotificationCompat.Builder notification_builder;
    String username;
    public MyNewIntentService() {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.e(MyNewIntentService.class.getSimpleName(),"Entered MyNewIntentService");
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
                .setContentText("Hey "+username+".Check out the recipe of the day!")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
        Log.e("notif","Building");
        notification_manager.notify(3000, notification_builder.build());

    }
    private void loadInfo() {
        SharedPreferences sharedpref = getSharedPreferences("userdetails", MODE_PRIVATE);
        username=sharedpref.getString("Username","User");
    }

}