package com.dnnr.DNNR_tier3.models;

import java.util.LinkedList;
import java.util.List;

public class Recipe
{
    private String name;
    private List<RecipeIngredient> recipeIngredient;

    public Recipe()
    {
        recipeIngredient = new LinkedList<>();
    }

    public String getName()
    {
        return name;
    }

    public List<RecipeIngredient> getRecipeIngredient()
    {
        return recipeIngredient;
    }
}
