package com.example.android.tastease.cuisine;

import android.view.MenuItem;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CuisineBody {

    @SerializedName("Menu Items")
    @Expose
    private List<MenuItem> menuItems = null;
    @SerializedName("Grocery Products")
    @Expose
    private List<GroceryProduct> groceryProducts = null;
    @SerializedName("Recipes")
    @Expose
    private List<Recipe> recipes = null;
    @SerializedName("Articles")
    @Expose
    private List<Article> articles = null;

    /**
     * No args constructor for use in serialization
     */
    public CuisineBody() {
    }

    /**
     * @param articles
     * @param recipes
     * @param groceryProducts
     * @param menuItems
     */
    public CuisineBody(List<MenuItem> menuItems, List<GroceryProduct> groceryProducts, List<Recipe> recipes, List<Article> articles) {
        super();
        this.menuItems = menuItems;
        this.groceryProducts = groceryProducts;
        this.recipes = recipes;
        this.articles = articles;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<GroceryProduct> getGroceryProducts() {
        return groceryProducts;
    }

    public void setGroceryProducts(List<GroceryProduct> groceryProducts) {
        this.groceryProducts = groceryProducts;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}