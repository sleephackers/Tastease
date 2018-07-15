package com.example.android.tastease;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.android.tastease.RetrofitCalls.ApiClient;
import com.example.android.tastease.RetrofitCalls.ApiInterface;
import com.example.android.tastease.food.BodyFood;
import com.example.android.tastease.food.FoodResponse;
import com.example.android.tastease.food.Result;
import com.example.android.tastease.video.Video;
import com.example.android.tastease.video.VideoResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultFoodActivity extends AppCompatActivity {
    public static final String MASHAPE_KEY = "PGIXJ1K3p3mshZ2ZRepaPon5MGYup1oY7h3jsn5nAD6hvZDodE";
    // public static final String MASHAPE_KEY = "BUh8bFqDuDmshI1JDP9FB4PfA22Gp1zKGPwjsnJ8g6SqbNv84x";
    public static final String APP_JSON_CONTENT_TYPE_HEADER = "application/json";
    public static final String JSON_ACCEPT_HEADER = "application/json";
    String foodname;
    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private BodyFood bodyFood;
    private MyFoodRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_video);
        Bundle extras = getIntent().getExtras();
        foodname = extras.getString("foodname");
        Log.e(ResultFoodActivity.class.getSimpleName(), "foodname:" + foodname);

        recyclerView = (RecyclerView) findViewById(R.id.video_result);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchVideos();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }


            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

    public void fetchVideos() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<BodyFood> call = apiInterface.getFoodRecipe(MASHAPE_KEY, APP_JSON_CONTENT_TYPE_HEADER, JSON_ACCEPT_HEADER, foodname, "2");

        call.enqueue(new Callback<BodyFood>() {
            @Override
            public void onResponse(Call<BodyFood> call, Response<BodyFood> response) {
                Log.e(ResultFoodActivity.class.getSimpleName(), "STATUS: " + response.code());
                bodyFood = response.body();
                adapter = new MyFoodRecyclerAdapter(bodyFood, ResultFoodActivity.this);
                recyclerView.setAdapter(adapter);
            }


            @Override
            public void onFailure(Call<BodyFood> call, Throwable t) {
                Log.e(ResultFoodActivity.class.getSimpleName(), t.toString());
            }
        });
    }
}
