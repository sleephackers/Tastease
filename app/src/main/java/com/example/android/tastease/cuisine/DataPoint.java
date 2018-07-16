package com.example.android.tastease.cuisine;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPoint {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("show")
    @Expose
    private Boolean show;
    @SerializedName("single")
    @Expose
    private Boolean single;

    /**
     * No args constructor for use in serialization
     */
    public DataPoint() {
    }

    /**
     * @param single
     * @param value
     * @param show
     * @param key
     */
    public DataPoint(String key, String value, Boolean show, Boolean single) {
        super();
        this.key = key;
        this.value = value;
        this.show = show;
        this.single = single;
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

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Boolean getSingle() {
        return single;
    }

    public void setSingle(Boolean single) {
        this.single = single;
    }

}