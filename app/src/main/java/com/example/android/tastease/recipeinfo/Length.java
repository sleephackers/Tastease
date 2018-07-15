package com.example.android.tastease.recipeinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Length {

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("unit")
    @Expose
    private String unit;

    /**
     * No args constructor for use in serialization
     */
    public Length() {
    }

    /**
     * @param unit
     * @param number
     */
    public Length(Integer number, String unit) {
        super();
        this.number = number;
        this.unit = unit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}