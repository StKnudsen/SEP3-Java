package com.dnnr.DNNR_tier3.models;

import java.util.LinkedList;
import java.util.List;

public class Recipe
{
    private final String name;
    private final List<RecipeIngredient> recipeIngredient;

    public Recipe(String name)
    {
        this.name = name;
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
