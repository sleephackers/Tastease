package com.example.android.tastease.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("shortTitle")
    @Expose
    private String shortTitle;
    @SerializedName("youTubeId")
    @Expose
    private String youTubeId;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("length")
    @Expose
    private Integer length;

    /**
     * No args constructor for use in serialization
     */
    public Video() {
    }

    /**
     * @param title
     * @param thumbnail
     * @param shortTitle
     * @param views
     * @param length
     * @param rating
     * @param youTubeId
     */
    public Video(String title, String shortTitle, String youTubeId, Double rating, Integer views, String thumbnail, Integer length) {
        super();
        this.title = title;
        this.shortTitle = shortTitle;
        this.youTubeId = youTubeId;
        this.rating = rating;
        this.views = views;
        this.thumbnail = thumbnail;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getYouTubeId() {
        return youTubeId;
    }

    public void setYouTubeId(String youTubeId) {
        this.youTubeId = youTubeId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

}