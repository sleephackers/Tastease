package com.example.android.tastease.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.tastease.MyFoodRecyclerAdapter;
import com.example.android.tastease.R;
import com.example.android.tastease.RetrofitCalls.ApiClient;
import com.example.android.tastease.RetrofitCalls.ApiInterface;
import com.example.android.tastease.food.BodyFood;
import com.example.android.tastease.trivia.TriviaBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogActivity extends AppCompatActivity {
    public static final String MASHAPE_KEY = "PGIXJ1K3p3mshZ2ZRepaPon5MGYup1oY7h3jsn5nAD6hvZDodE";
    // public static final String MASHAPE_KEY = "BUh8bFqDuDmshI1JDP9FB4PfA22Gp1zKGPwjsnJ8g6SqbNv84x";
    public static final String APP_JSON_CONTENT_TYPE_HEADER = "application/json";
    public static final String JSON_ACCEPT_HEADER = "application/json";
    TextView prof, triviaText, random, ingredientsearch;
    ApiInterface apiInterface;
    ImageView videorecipes;
    LinearLayout trivia;
    RelativeLayout steak, chicken, eggs, italian, chinese, indian, korean, mealplan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        videorecipes=findViewById(R.id.video_recipes);
        steak = findViewById(R.id.steak);
        triviaText = findViewById(R.id.triviaText);
        trivia = (LinearLayout) findViewById(R.id.trivia);
        chicken = findViewById(R.id.chicken);
        italian = findViewById(R.id.italian);
        chinese = findViewById(R.id.chinese);
        indian = findViewById(R.id.indian);
        korean = findViewById(R.id.korean);
        eggs = findViewById(R.id.eggs);
        prof=findViewById(R.id.profilecat);
        random = findViewById(R.id.randomrecipe);
        ingredientsearch = findViewById(R.id.ingredientsearch);
        mealplan = findViewById(R.id.mealplan);
        trivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchTrivia();
            }
        });
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CatalogActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, RandomFoodActivity.class);
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
        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, ResultFoodActivity.class);
                Bundle extras = new Bundle();
                extras.putString("foodname", "italian");
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, ResultFoodActivity.class);
                Bundle extras = new Bundle();
                extras.putString("foodname", "chinese");
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        indian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, ResultFoodActivity.class);
                Bundle extras = new Bundle();
                extras.putString("foodname", "indian");
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, ResultFoodActivity.class);
                Bundle extras = new Bundle();
                extras.putString("foodname", "korean");
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        mealplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, MealPlanSearch.class);
                startActivity(intent);
            }
        });
        ingredientsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, IngredientSearch.class);
                startActivity(intent);
            }
        });



    }

    private void fetchTrivia() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<TriviaBody> call = apiInterface.getTrivia(MASHAPE_KEY, APP_JSON_CONTENT_TYPE_HEADER, JSON_ACCEPT_HEADER);

        call.enqueue(new Callback<TriviaBody>() {
            @Override
            public void onResponse(Call<TriviaBody> call, Response<TriviaBody> response) {
                Log.e(ResultFoodActivity.class.getSimpleName(), "STATUS: " + response.code());
                triviaText.setText(response.body().getText());
                Log.e(ResultFoodActivity.class.getSimpleName(), "TRIVIA: " + response.code());

            }


            @Override
            public void onFailure(Call<TriviaBody> call, Throwable t) {
                Log.e(ResultFoodActivity.class.getSimpleName(), t.toString());
            }
        });
    }
}
