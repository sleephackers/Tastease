package com.example.android.tastease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CatalogActivity extends AppCompatActivity {
    TextView prof;
    ImageView videorecipes;
    RelativeLayout steak, chicken, eggs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        videorecipes=findViewById(R.id.video_recipes);
        steak = findViewById(R.id.steak);
        chicken = findViewById(R.id.chicken);
        eggs = findViewById(R.id.eggs);
        prof=findViewById(R.id.profilecat);
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CatalogActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        videorecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CatalogActivity.this, SearchActivity.class);
                startActivity(intent1);
            }
        });
        steak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, ResultFoodActivity.class);
                Bundle extras = new Bundle();
                extras.putString("foodname", "steak");
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, ResultFoodActivity.class);
                Bundle extras = new Bundle();
                extras.putString("foodname", "chicken");
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        eggs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, ResultFoodActivity.class);
                Bundle extras = new Bundle();
                extras.putString("foodname", "eggs");
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
