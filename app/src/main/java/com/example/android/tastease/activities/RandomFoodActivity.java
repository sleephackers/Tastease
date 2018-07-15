package com.example.android.tastease.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tastease.MyRecyclerAdapter;
import com.example.android.tastease.R;
import com.example.android.tastease.RetrofitCalls.ApiClient;
import com.example.android.tastease.RetrofitCalls.ApiInterface;
import com.example.android.tastease.randomfood.randomBody;
import com.example.android.tastease.recipeinfo.RecipeInformation;
import com.example.android.tastease.video.Video;
import com.example.android.tastease.video.VideoResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomFoodActivity extends AppCompatActivity {
    public static final String MASHAPE_KEY = "PGIXJ1K3p3mshZ2ZRepaPon5MGYup1oY7h3jsn5nAD6hvZDodE";
    // public static final String MASHAPE_KEY = "BUh8bFqDuDmshI1JDP9FB4PfA22Gp1zKGPwjsnJ8g6SqbNv84x";
    public static final String APP_JSON_CONTENT_TYPE_HEADER = "application/json";
    public static final String JSON_ACCEPT_HEADER = "application/json";
    String id, instructionstext = "", ingredientsList = "";
    ImageView imageView;
    TextView title, time, servings, instructions, source, ingredients;
    ApiInterface apiInterface;
    RecipeInformation recipeInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);
        title = findViewById(R.id.title);
        time = findViewById(R.id.time);
        servings = findViewById(R.id.servings);
        ingredients = findViewById(R.id.ingredients);
        instructions = findViewById(R.id.instructions);
        source = findViewById(R.id.source);
        imageView = findViewById(R.id.image);
        fetchFoodInfo();
        source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri sourceUri = Uri.parse(recipeInformation.getSourceUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, sourceUri);
                startActivity(websiteIntent);
            }
        });
    }

    private void fetchFoodInfo() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<randomBody> call = apiInterface.getRandomFood(MASHAPE_KEY, APP_JSON_CONTENT_TYPE_HEADER, JSON_ACCEPT_HEADER, "1");

        call.enqueue(new Callback<randomBody>() {
            @Override
            public void onResponse(Call<randomBody> call, Response<randomBody> response) {
                Log.e(ResultVideoActivity.class.getSimpleName(), "STATUS: " + response.body());
                recipeInformation = response.body().getRecipes().get(0);
                title.setText(recipeInformation.getTitle());
                time.setText(recipeInformation.getReadyInMinutes().toString() + "  Min");
                servings.setText(recipeInformation.getServings().toString());
                for (int i = 0; i < recipeInformation.getAnalyzedInstructions().get(0).getSteps().size(); i++)
                    instructionstext += "\n\n" + (i + 1) + "." + " " + recipeInformation.getAnalyzedInstructions().get(0).getSteps().get(i).getStep();
                instructions.setText(instructionstext);
                for (int i = 0; i < recipeInformation.getExtendedIngredients().size(); i++)
                    ingredientsList += "\n\n" + (i + 1) + "." + " " + recipeInformation.getExtendedIngredients().get(i).getName();
                ingredients.setText(ingredientsList);
                Picasso.get()
                        .load(recipeInformation.getImage())
                        .resize(800, 800)
                        .into(imageView);
            }


            @Override
            public void onFailure(Call<randomBody> call, Throwable t) {
                Log.e(RandomFoodActivity.class.getSimpleName(), t.toString());
            }
        });
    }


}
