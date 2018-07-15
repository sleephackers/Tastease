package com.example.android.tastease.randomfood;

import java.util.List;

import com.example.android.tastease.recipeinfo.RecipeInformation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class randomBody {

    @SerializedName("recipes")
    @Expose
    private List<RecipeInformation> recipes = null;

    /**
     * No args constructor for use in serialization
     */
    public randomBody() {
    }

    /**
     * @param recipes
     */
    public randomBody(List<RecipeInformation> recipes) {
        super();
        this.recipes = recipes;
    }

    public List<RecipeInformation> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeInformation> recipes) {
        this.recipes = recipes;
    }

}