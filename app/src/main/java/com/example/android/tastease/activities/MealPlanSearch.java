package com.example.android.tastease.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.tastease.R;

public class MealPlanSearch extends AppCompatActivity {
    Button search;
    EditText calories, exclude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan_search);
        search = findViewById(R.id.search);
        calories = findViewById(R.id.calories);
        exclude = findViewById(R.id.exclude);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MealPlanSearch.this, ResultFoodActivity.class);
                Bundle extras = new Bundle();
                extras.putString("calories", calories.getText().toString());
                extras.putString("exclude", exclude.getText().toString());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
