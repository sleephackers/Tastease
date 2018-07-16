package com.example.android.tastease.mealplan;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealBody {

    @SerializedName("meals")
    @Expose
    private List<Meal> meals = null;
    @SerializedName("nutrients")
    @Expose
    private Nutrients nutrients;

    /**
     * No args constructor for use in serialization
     */
    public MealBody() {
    }

    /**
     * @param nutrients
     * @param meals
     */
    public MealBody(List<Meal> meals, Nutrients nutrients) {
        super();
        this.meals = meals;
        this.nutrients = nutrients;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

}