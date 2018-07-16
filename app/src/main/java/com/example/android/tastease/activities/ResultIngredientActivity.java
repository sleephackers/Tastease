package com.example.android.tastease.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.android.tastease.IngredientBody;
import com.example.android.tastease.MyFoodRecyclerAdapter;
import com.example.android.tastease.MyIngredientRecyclerAdapter;
import com.example.android.tastease.R;
import com.example.android.tastease.RecyclerTouchListener;
import com.example.android.tastease.RetrofitCalls.ApiClient;
import com.example.android.tastease.RetrofitCalls.ApiInterface;
import com.example.android.tastease.food.BodyFood;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultIngredientActivity extends AppCompatActivity {
    //public static final String MASHAPE_KEY = "PGIXJ1K3p3mshZ2ZRepaPon5MGYup1oY7h3jsn5nAD6hvZDodE";
    public static final String MASHAPE_KEY = "BUh8bFqDuDmshI1JDP9FB4PfA22Gp1zKGPwjsnJ8g6SqbNv84x";
    public static final String APP_JSON_CONTENT_TYPE_HEADER = "application/json";
    public static final String JSON_ACCEPT_HEADER = "application/json";
    String ingredients;
    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<IngredientBody> ingredientBody;
    private MyIngredientRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_video);
        Bundle extras = getIntent().getExtras();
        ingredients = extras.getString("ingredients");

        recyclerView = (RecyclerView) findViewById(R.id.video_result);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchFood();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(ResultIngredientActivity.this, RecipeInfoActivity.class);
                Bundle extras = new Bundle();
                extras.putString("id", ingredientBody.get(position).getId().toString());
                Log.e(ResultFoodActivity.class.getSimpleName(), "Clickeddddddddd" + extras);
                intent.putExtras(extras);
                startActivity(intent);
            }


            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

    public void fetchFood() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<IngredientBody>> call = apiInterface.findRecipesByIngredients(MASHAPE_KEY, APP_JSON_CONTENT_TYPE_HEADER, JSON_ACCEPT_HEADER, ingredients, "1", "1");

        call.enqueue(new Callback<List<IngredientBody>>() {
            @Override
            public void onResponse(Call<List<IngredientBody>> call, Response<List<IngredientBody>> response) {
                Log.e(ResultIngredientActivity.class.getSimpleName(), "STATUS: " + response.code());
                ingredientBody = response.body();
                adapter = new MyIngredientRecyclerAdapter(ingredientBody, ResultIngredientActivity.this);
                recyclerView.setAdapter(adapter);
            }


            @Override
            public void onFailure(Call<List<IngredientBody>> call, Throwable t) {
                Log.e(ResultIngredientActivity.class.getSimpleName(), t.toString());
            }
        });
    }
}
