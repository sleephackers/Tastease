package com.example.android.tastease.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.android.tastease.MyRecyclerAdapter;
import com.example.android.tastease.R;
import com.example.android.tastease.RecyclerTouchListener;
import com.example.android.tastease.RetrofitCalls.ApiClient;
import com.example.android.tastease.RetrofitCalls.ApiInterface;
import com.example.android.tastease.video.Video;
import com.example.android.tastease.video.VideoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultVideoActivity extends AppCompatActivity {
    //public static final String MASHAPE_KEY = "PGIXJ1K3p3mshZ2ZRepaPon5MGYup1oY7h3jsn5nAD6hvZDodE";
    public static final String MASHAPE_KEY = "BUh8bFqDuDmshI1JDP9FB4PfA22Gp1zKGPwjsnJ8g6SqbNv84x";
    public static final String APP_JSON_CONTENT_TYPE_HEADER = "application/json";
    String name, include, exclude;
    ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Video> videos;
    public static final String JSON_ACCEPT_HEADER = "application/json";
    private MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_video);
        Bundle extras = getIntent().getExtras();
        name = extras.getString("name");
        include = extras.getString("include");
        exclude = extras.getString("exclude");
        recyclerView = (RecyclerView) findViewById(R.id.video_result);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        Log.e(ResultVideoActivity.class.getSimpleName(), "eeeeee: " + name + " " + include + " " + exclude);
        fetchVideos();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videos.get(position).getYouTubeId()));
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.youtube.com/watch?v=" + videos.get(position).getYouTubeId()));
                try {
                    startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }


            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }
    public void fetchVideos() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<VideoResponse> call = apiInterface.getRecipeVideos(MASHAPE_KEY, APP_JSON_CONTENT_TYPE_HEADER, JSON_ACCEPT_HEADER, name, exclude, include, "1");

        call.enqueue(new Callback<VideoResponse>() {
            @Override
            public void onResponse(Call<VideoResponse> call, Response<VideoResponse> response) {
                Log.e(ResultVideoActivity.class.getSimpleName(),"STATUS: "+response.code());
                Log.e(ResultVideoActivity.class.getSimpleName(), "RESPONSE EEEE: " + response.body().getVideos().get(0).getYouTubeId());
                videos = response.body().getVideos();
                adapter = new MyRecyclerAdapter(videos, ResultVideoActivity.this);
                Log.e(ResultVideoActivity.class.getSimpleName(), "RESPONSE: " + response.body().getVideos().get(0).getYouTubeId());
                recyclerView.setAdapter(adapter);
                }




            @Override
            public void onFailure(Call<VideoResponse> call, Throwable t) {
                Log.e(ResultVideoActivity.class.getSimpleName(), t.toString());
            }
        });
    }
}
