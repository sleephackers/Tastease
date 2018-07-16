package com.example.android.tastease.recipeinfo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeInformation {

    @SerializedName("vegetarian")
    @Expose
    private Boolean vegetarian;
    @SerializedName("vegan")
    @Expose
    private Boolean vegan;
    @SerializedName("glutenFree")
    @Expose
    private Boolean glutenFree;
    @SerializedName("dairyFree")
    @Expose
    private Boolean dairyFree;
    @SerializedName("veryHealthy")
    @Expose
    private Boolean veryHealthy;
    @SerializedName("cheap")
    @Expose
    private Boolean cheap;
    @SerializedName("veryPopular")
    @Expose
    private Boolean veryPopular;
    @SerializedName("sustainable")
    @Expose
    private Boolean sustainable;
    @SerializedName("weightWatcherSmartPoints")
    @Expose
    private Integer weightWatcherSmartPoints;
    @SerializedName("gaps")
    @Expose
    private String gaps;
    @SerializedName("lowFodmap")
    @Expose
    private Boolean lowFodmap;
    @SerializedName("ketogenic")
    @Expose
    private Boolean ketogenic;
    @SerializedName("whole30")
    @Expose
    private Boolean whole30;
    @SerializedName("preparationMinutes")
    @Expose
    private Integer preparationMinutes;
    @SerializedName("cookingMinutes")
    @Expose
    private Integer cookingMinutes;
    @SerializedName("sourceUrl")
    @Expose
    private String sourceUrl;
    @SerializedName("spoonacularSourceUrl")
    @Expose
    private String spoonacularSourceUrl;
    @SerializedName("aggregateLikes")
    @Expose
    private Integer aggregateLikes;
    @SerializedName("spoonacularScore")
    @Expose
    private Integer spoonacularScore;
    @SerializedName("healthScore")
    @Expose
    private Integer healthScore;
    @SerializedName("creditText")
    @Expose
    private String creditText;
    @SerializedName("sourceName")
    @Expose
    private String sourceName;
    @SerializedName("pricePerServing")
    @Expose
    private Double pricePerServing;
    @SerializedName("extendedIngredients")
    @Expose
    private List<ExtendedIngredient> extendedIngredients = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("readyInMinutes")
    @Expose
    private Integer readyInMinutes;
    @SerializedName("servings")
    @Expose
    private Integer servings;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("imageType")
    @Expose
    private String imageType;
    @SerializedName("cuisines")
    @Expose
    private List<Object> cuisines = null;
    @SerializedName("dishTypes")
    @Expose
    private List<String> dishTypes = null;
    @SerializedName("diets")
    @Expose
    private List<String> diets = null;
    @SerializedName("occasions")
    @Expose
    private List<Object> occasions = null;
    @SerializedName("winePairing")
    @Expose
    private WinePairing winePairing;
    @SerializedName("instructions")
    @Expose
    private String instructions;
    @SerializedName("analyzedInstructions")
    @Expose
    private List<AnalyzedInstruction> analyzedInstructions = null;
    @SerializedName("creditsText")
    @Expose
    private String creditsText;

    /**
     * No args constructor for use in serialization
     */
    public RecipeInformation() {
    }

    /**
     *
     * @param creditsText
     * @param instructions
     * @param preparationMinutes
     * @param ketogenic
     * @param diets
     * @param sustainable
     * @param sourceUrl
     * @param dishTypes
     * @param veryHealthy
     * @param id
     * @param servings
     * @param title
     * @param lowFodmap
     * @param sourceName
     * @param vegetarian
     * @param healthScore
     * @param occasions
     * @param spoonacularScore
     * @param cuisines
     * @param dairyFree
     * @param creditText
     * @param whole30
     * @param aggregateLikes
     * @param analyzedInstructions
     * @param image
     * @param readyInMinutes
     * @param spoonacularSourceUrl
     * @param pricePerServing
     * @param cookingMinutes
     * @param glutenFree
     * @param gaps
     * @param weightWatcherSmartPoints
     * @param vegan
     * @param winePairing
     * @param imageType
     * @param cheap
     * @param veryPopular
     * @param extendedIngredients
     */
    public RecipeInformation(Boolean vegetarian, Boolean vegan, Boolean glutenFree, Boolean dairyFree, Boolean veryHealthy, Boolean cheap, Boolean veryPopular, Boolean sustainable, Integer weightWatcherSmartPoints, String gaps, Boolean lowFodmap, Boolean ketogenic, Boolean whole30, Integer preparationMinutes, Integer cookingMinutes, String sourceUrl, String spoonacularSourceUrl, Integer aggregateLikes, Integer spoonacularScore, Integer healthScore, String creditText, String sourceName, Double pricePerServing, List<ExtendedIngredient> extendedIngredients, Integer id, String title, Integer readyInMinutes, Integer servings, String image, String imageType, List<Object> cuisines, List<String> dishTypes, List<String> diets, List<Object> occasions, WinePairing winePairing, String instructions, List<AnalyzedInstruction> analyzedInstructions, String creditsText) {
        super();
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.dairyFree = dairyFree;
        this.veryHealthy = veryHealthy;
        this.cheap = cheap;
        this.veryPopular = veryPopular;
        this.sustainable = sustainable;
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
        this.gaps = gaps;
        this.lowFodmap = lowFodmap;
        this.ketogenic = ketogenic;
        this.whole30 = whole30;
        this.preparationMinutes = preparationMinutes;
        this.cookingMinutes = cookingMinutes;
        this.sourceUrl = sourceUrl;
        this.spoonacularSourceUrl = spoonacularSourceUrl;
        this.aggregateLikes = aggregateLikes;
        this.spoonacularScore = spoonacularScore;
        this.healthScore = healthScore;
        this.creditText = creditText;
        this.sourceName = sourceName;
        this.pricePerServing = pricePerServing;
        this.extendedIngredients = extendedIngredients;
        this.id = id;
        this.title = title;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.image = image;
        this.imageType = imageType;
        this.cuisines = cuisines;
        this.dishTypes = dishTypes;
        this.diets = diets;
        this.occasions = occasions;
        this.winePairing = winePairing;
        this.instructions = instructions;
        this.analyzedInstructions = analyzedInstructions;
        this.creditsText = creditsText;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public Boolean getDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(Boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public Boolean getVeryHealthy() {
        return veryHealthy;
    }

    public void setVeryHealthy(Boolean veryHealthy) {
        this.veryHealthy = veryHealthy;
    }

    public Boolean getCheap() {
        return cheap;
    }

    public void setCheap(Boolean cheap) {
        this.cheap = cheap;
    }

    public Boolean getVeryPopular() {
        return veryPopular;
    }

    public void setVeryPopular(Boolean veryPopular) {
        this.veryPopular = veryPopular;
    }

    public Boolean getSustainable() {
        return sustainable;
    }

    public void setSustainable(Boolean sustainable) {
        this.sustainable = sustainable;
    }

    public Integer getWeightWatcherSmartPoints() {
        return weightWatcherSmartPoints;
    }

    public void setWeightWatcherSmartPoints(Integer weightWatcherSmartPoints) {
        this.weightWatcherSmartPoints = weightWatcherSmartPoints;
    }

    public String getGaps() {
        return gaps;
    }

    public void setGaps(String gaps) {
        this.gaps = gaps;
    }

    public Boolean getLowFodmap() {
        return lowFodmap;
    }

    public void setLowFodmap(Boolean lowFodmap) {
        this.lowFodmap = lowFodmap;
    }

    public Boolean getKetogenic() {
        return ketogenic;
    }

    public void setKetogenic(Boolean ketogenic) {
        this.ketogenic = ketogenic;
    }

    public Boolean getWhole30() {
        return whole30;
    }

    public void setWhole30(Boolean whole30) {
        this.whole30 = whole30;
    }

    public Integer getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(Integer preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    public Integer getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(Integer cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSpoonacularSourceUrl() {
        return spoonacularSourceUrl;
    }

    public void setSpoonacularSourceUrl(String spoonacularSourceUrl) {
        this.spoonacularSourceUrl = spoonacularSourceUrl;
    }

    public Integer getAggregateLikes() {
        return aggregateLikes;
    }

    public void setAggregateLikes(Integer aggregateLikes) {
        this.aggregateLikes = aggregateLikes;
    }

    public Integer getSpoonacularScore() {
        return spoonacularScore;
    }

    public void setSpoonacularScore(Integer spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
    }

    public Integer getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(Integer healthScore) {
        this.healthScore = healthScore;
    }

    public String getCreditText() {
        return creditText;
    }

    public void setCreditText(String creditText) {
        this.creditText = creditText;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Double getPricePerServing() {
        return pricePerServing;
    }

    public void setPricePerServing(Double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    public List<ExtendedIngredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(List<ExtendedIngredient> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public List<Object> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Object> cuisines) {
        this.cuisines = cuisines;
    }

    public List<String> getDishTypes() {
        return dishTypes;
    }

    public void setDishTypes(List<String> dishTypes) {
        this.dishTypes = dishTypes;
    }

    public List<String> getDiets() {
        return diets;
    }

    public void setDiets(List<String> diets) {
        this.diets = diets;
    }

    public List<Object> getOccasions() {
        return occasions;
    }

    public void setOccasions(List<Object> occasions) {
        this.occasions = occasions;
    }

    public WinePairing getWinePairing() {
        return winePairing;
    }

    public void setWinePairing(WinePairing winePairing) {
        this.winePairing = winePairing;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<AnalyzedInstruction> getAnalyzedInstructions() {
        return analyzedInstructions;
    }

    public void setAnalyzedInstructions(List<AnalyzedInstruction> analyzedInstructions) {
        this.analyzedInstructions = analyzedInstructions;
    }

    public String getCreditsText() {
        return creditsText;
    }

    public void setCreditsText(String creditsText) {
        this.creditsText = creditsText;
    }

}