package com.example.android.tastease.RetrofitCalls;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("recipes/findByIngredients")
    Call<List<Recipe>> findRecipesByIngredients(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Query("fillIngredients") boolean fillIngredients,
            @Query("ingredients") String ingredients,
            @Query("limitLicense") boolean limitLicense,
            @Query("number") Integer number,
            @Query("ranking") Integer ranking);

    @GET("recipes/{id}/information")
    Call<RecipeInformation> getRecipeInformation(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Path("id") int id,
            @Query("includeNutrition") boolean includeNutrition);

}
