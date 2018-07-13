package com.example.android.tastease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CatalogActivity extends AppCompatActivity {
    TextView prof;
    ImageView videorecipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        videorecipes=findViewById(R.id.video_recipes);
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
                Intent intent=new Intent(CatalogActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });}
}
