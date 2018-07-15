package com.example.android.tastease.food;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodResponse {

    @SerializedName("body")
    @Expose
    private BodyFood body;

    /**
     * No args constructor for use in serialization
     */
    public FoodResponse() {
    }

    /**
     * @param body
     */
    public FoodResponse(BodyFood body) {
        super();
        this.body = body;
    }

    public BodyFood getBody() {
        return body;
    }

    public void setBody(BodyFood body) {
        this.body = body;
    }

}