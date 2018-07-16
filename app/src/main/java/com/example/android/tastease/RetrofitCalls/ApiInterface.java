package com.example.android.tastease.RetrofitCalls;


import com.example.android.tastease.IngredientBody;
import com.example.android.tastease.mealplan.MealBody;
import com.example.android.tastease.randomfood.randomBody;
import com.example.android.tastease.recipeinfo.RecipeInformation;
import com.example.android.tastease.food.BodyFood;
import com.example.android.tastease.trivia.TriviaBody;
import com.example.android.tastease.video.VideoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("recipes/findByIngredients")
    Call<List<IngredientBody>> findRecipesByIngredients(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Query("ingredients") String ingredients,
            @Query("number") String number,
            @Query("ranking") String ranking);

    @GET("recipes/{id}/information")
    Call<RecipeInformation> getRecipeInformation(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Path("id") String id,
            @Query("includeNutrition") boolean includeNutrition);

    @GET("food/videos/search")
    Call<VideoResponse> getRecipeVideos(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Query("query") String query,
            @Query("excludeingredients") String exclude,
            @Query("includeingredients") String include,
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

    @GET("food/trivia/random")
    Call<TriviaBody> getTrivia(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept
    );

    @GET("recipes/random")
    Call<randomBody> getRandomFood(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Query("number") String number

    );

    @GET("recipes/mealplans/generate")
    Call<MealBody> getMealPlan(
            @Header("X-Mashape-Key") String mashapeKey,
            @Header("Content-Type") String contentType,
            @Header("Accept") String accept,
            @Query("targetCalories") String calories,
            @Query("exclude") String exclude

    );


}
