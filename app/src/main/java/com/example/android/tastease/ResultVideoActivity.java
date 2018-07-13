package com.example.android.tastease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.tastease.RetrofitCalls.ApiClient;
import com.example.android.tastease.RetrofitCalls.ApiInterface;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultVideoActivity extends AppCompatActivity {
String name,type,cuisine;
    public static final String BASE_URL = "https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/";
    public static final String MASHAPE_KEY = "BUh8bFqDuDmshI1JDP9FB4PfA22Gp1zKGPwjsnJ8g6SqbNv84x";
    public static final String APP_JSON_CONTENT_TYPE_HEADER = "application/json";
    public static final String URL_FORM_CONTENT_TYPE_HEADER = "application/x-www-form-urlencoded";
    public static final String JSON_ACCEPT_HEADER = "application/json";
    public static final String TEXT_HTML_ACCEPT_HEADER = "text/html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_video);
        Bundle extras = getIntent().getExtras();
        name = extras.getString("name");
        type = extras.getString("type");
        cuisine = extras.getString("cuisine");
        fetchVideos();
    }
    public void fetchVideos() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<VideoResponse> call = apiInterface.getCharacter(name);
        call.enqueue(new Callback<VideoResponse>() {
            @Override
            public void onResponse(Call<VideoResponse> call, Response<VideoResponse> response) {
                Log.e(ResultVideoActivity.class.getSimpleName(),"STATUS: "+response.code());

                }




            @Override
            public void onFailure(Call<VideoResponse> call, Throwable t) {
                Log.e(ResultVideoActivity.class.getSimpleName(), t.toString());
            }
        });
    }
}
