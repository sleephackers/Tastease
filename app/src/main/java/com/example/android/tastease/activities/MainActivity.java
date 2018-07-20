package com.example.android.tastease.activities;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.tastease.R;
import com.example.android.tastease.RetrofitCalls.ApiClient;
import com.example.android.tastease.RetrofitCalls.ApiInterface;
import com.example.android.tastease.trivia.TriviaBody;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String MASHAPE_KEY = "PGIXJ1K3p3mshZ2ZRepaPon5MGYup1oY7h3jsn5nAD6hvZDodE";
    // public static final String MASHAPE_KEY = "BUh8bFqDuDmshI1JDP9FB4PfA22Gp1zKGPwjsnJ8g6SqbNv84x";
    public static final String APP_JSON_CONTENT_TYPE_HEADER = "application/json";
    public static final String JSON_ACCEPT_HEADER = "application/json";
    ApiInterface apiInterface;
    TextView profile;
    Button skip;
    NetworkInfo networkInfo;
    LinearLayout fb,gmail;
    String fact="";
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent notifyIntent = new Intent(this,MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 19);
//        calendar.set(Calendar.MINUTE, 00);
//        calendar.set(Calendar.SECOND, 00);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+1000*3, 1000*60 , pendingIntent);
        super.onCreate(savedInstanceState);
        fetchTrivia();
        setContentView(R.layout.activity_main);
        profile=findViewById(R.id.profile_settings);
        skip=findViewById(R.id.skip);
        fb=findViewById(R.id.fb);
        gmail=findViewById(R.id.gmail);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              loadInfo();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent
                        .putExtra(Intent.EXTRA_TEXT,
                                "Your friend "+username+" loves using Tastease,the cooking app which brings thousands of Recipes to your fingertips, free of cost!Try it out :)");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.facebook.orca");
                try {
                    startActivity(sendIntent);
                }
                catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this,"Please Install Facebook Messenger", Toast.LENGTH_LONG).show();
                }

          }
        });
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInfo();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_TEXT,"Your friend "+username+" loves using Tastease,the cooking app which brings thousands of Recipes to your fingertips, free of cost!Try it out :)" );
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
               else{
                    Toast.makeText(MainActivity.this,"No relevant Email app available", Toast.LENGTH_LONG).show();
                }
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (android.net.ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);

                // Get details on the currently active default data network
                networkInfo = connMgr.getActiveNetworkInfo();

                // If there is a network connection, fetch data
                if (networkInfo != null && networkInfo.isConnected()) {
                    Intent intent = new Intent(MainActivity.this, CatalogActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this,"Please Check Connectivity Status", Toast.LENGTH_LONG).show();


            }
        });

    }
    private void loadInfo() {
        SharedPreferences sharedpref = getSharedPreferences("userdetails", MODE_PRIVATE);
        username=sharedpref.getString("Username","User");
        Log.e(MainActivity.class.getSimpleName(),"Loadinggg"+ username);


    }
    private void fetchTrivia() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<TriviaBody> call = apiInterface.getTrivia(MASHAPE_KEY, APP_JSON_CONTENT_TYPE_HEADER, JSON_ACCEPT_HEADER);

        call.enqueue(new Callback<TriviaBody>() {
            @Override
            public void onResponse(Call<TriviaBody> call, Response<TriviaBody> response) {
                Log.e(ResultFoodActivity.class.getSimpleName(), "STATUS: " + response.code());
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Food for Thought");
                alertDialogBuilder.setMessage(response.body().getText()).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });;
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }


            @Override
            public void onFailure(Call<TriviaBody> call, Throwable t) {
                Log.e(ResultFoodActivity.class.getSimpleName(), t.toString());
            }
        });
    }
}
