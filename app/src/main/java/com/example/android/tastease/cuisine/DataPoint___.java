package com.example.android.tastease.cuisine;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPoint___ {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("value")
    @Expose
    private String value;

    /**
     * No args constructor for use in serialization
     */
    public DataPoint___() {
    }

    /**
     * @param value
     * @param key
     */
    public DataPoint___(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

