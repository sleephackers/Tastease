package com.example.android.tastease.trivia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TriviaBody {

    @SerializedName("text")
    @Expose
    private String text;

    /**
     * No args constructor for use in serialization
     */
    public TriviaBody() {
    }

    /**
     * @param text
     */
    public TriviaBody(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}