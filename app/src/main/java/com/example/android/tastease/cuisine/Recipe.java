package com.example.android.tastease.cuisine;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recipe {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("kvtable")
    @Expose
    private String kvtable;
    @SerializedName("dataPoints")
    @Expose
    private List<DataPoint__> dataPoints = null;

    /**
     * No args constructor for use in serialization
     */
    public Recipe() {
    }

    /**
     * @param link
     * @param name
     * @param kvtable
     * @param image
     * @param dataPoints
     */
    public Recipe(String name, String image, String link, String kvtable, List<DataPoint__> dataPoints) {
        super();
        this.name = name;
        this.image = image;
        this.link = link;
        this.kvtable = kvtable;
        this.dataPoints = dataPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getKvtable() {
        return kvtable;
    }

    public void setKvtable(String kvtable) {
        this.kvtable = kvtable;
    }

    public List<DataPoint__> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(List<DataPoint__> dataPoints) {
        this.dataPoints = dataPoints;
    }

}