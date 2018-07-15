package com.example.android.tastease.RetrofitCalls;


import com.example.android.tastease.RecipeInformation;
import com.example.android.tastease.food.BodyFood;
import com.example.android.tastease.video.VideoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
   /* @GET("recipes/findByIngredients")
    Call<List<Recipe>> findRecipesByIngredients(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Query("fillIngredients") boolean fillIngredients,
            @Query("ingredients") String ingredients,
            @Query("limitLicense") boolean limitLicense,
            @Query("number") Integer number,
            @Query("ranking") Integer ranking);*/

    @GET("recipes/{id}/information")
    Call<RecipeInformation> getRecipeInformation(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Path("id") int id,
            @Query("includeNutrition") boolean includeNutrition);

    @GET("food/videos/search")
    Call<VideoResponse> getRecipeVideos(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Query("query") String query,
            @Query("excludeingredients") String exclude,
            @Query("includeingredients") String include,
            //  @Query("minLength") String minlength,
            //@Query("offset") String offset,
            @Query("number") String number

    );

    @GET("recipes/search")
    Call<BodyFood> getFoodRecipe(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Query("query") String query,
            @Query("number") String number

    );


}
