package com.example.android.tastease.activities;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity {
    TextView profile;
    Button skip;
    LinearLayout fb,gmail;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                Intent intent=new Intent(MainActivity.this,CatalogActivity.class);
                startActivity(intent);
            }
        });

    }
    private void loadInfo() {
        SharedPreferences sharedpref = getSharedPreferences("userdetails", MODE_PRIVATE);
        username=sharedpref.getString("Username","User");
        Log.e(MainActivity.class.getSimpleName(),"Loadinggg"+ username);


    }
}
