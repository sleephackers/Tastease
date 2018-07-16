package com.example.android.tastease.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.tastease.R;
import com.example.android.tastease.recipeinfo.Ingredient;

public class IngredientSearch extends AppCompatActivity {
    Button search;
    EditText ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_search);
        search = findViewById(R.id.search);
        ingredients = findViewById(R.id.ingredients);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IngredientSearch.this, ResultIngredientActivity.class);
                Bundle extras = new Bundle();
                extras.putString("ingredients", ingredients.getText().toString());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
