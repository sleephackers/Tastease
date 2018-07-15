package com.example.android.tastease.video;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoResponse {

    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;

    /**
     * No args constructor for use in serialization
     */
    public VideoResponse() {
    }

    /**
     * @param totalResults
     * @param videos
     */
    public VideoResponse(Integer totalResults, List<Video> videos) {
        super();
        this.totalResults = totalResults;
        this.videos = videos;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

}