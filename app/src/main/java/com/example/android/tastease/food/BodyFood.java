package com.example.android.tastease.food;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BodyFood {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("baseUri")
    @Expose
    private String baseUri;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("processingTimeMs")
    @Expose
    private Integer processingTimeMs;
    @SerializedName("expires")
    @Expose
    private String expires;
    @SerializedName("isStale")
    @Expose
    private Boolean isStale;

    /**
     * No args constructor for use in serialization
     */
    public BodyFood() {
    }

    /**
     * @param expires
     * @param results
     * @param totalResults
     * @param baseUri
     * @param number
     * @param offset
     * @param processingTimeMs
     * @param isStale
     */
    public BodyFood(List<Result> results, String baseUri, Integer offset, Integer number, Integer totalResults, Integer processingTimeMs, String expires, Boolean isStale) {
        super();
        this.results = results;
        this.baseUri = baseUri;
        this.offset = offset;
        this.number = number;
        this.totalResults = totalResults;
        this.processingTimeMs = processingTimeMs;
        this.expires = expires;
        this.isStale = isStale;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getProcessingTimeMs() {
        return processingTimeMs;
    }

    public void setProcessingTimeMs(Integer processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public Boolean getIsStale() {
        return isStale;
    }

    public void setIsStale(Boolean isStale) {
        this.isStale = isStale;
    }

}