package com.example.android.tastease.RetrofitCalls;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/";
    public static Retrofit retrofit=null;

    public static Retrofit getApiClient()
    {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
