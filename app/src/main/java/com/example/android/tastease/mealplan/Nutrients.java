package com.example.android.tastease.mealplan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrients {

    @SerializedName("calories")
    @Expose
    private Double calories;
    @SerializedName("protein")
    @Expose
    private Double protein;
    @SerializedName("fat")
    @Expose
    private Double fat;
    @SerializedName("carbohydrates")
    @Expose
    private Double carbohydrates;

    /**
     * No args constructor for use in serialization
     */
    public Nutrients() {
    }

    /**
     * @param protein
     * @param fat
     * @param carbohydrates
     * @param calories
     */
    public Nutrients(Double calories, Double protein, Double fat, Double carbohydrates) {
        super();
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

}