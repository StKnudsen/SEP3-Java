package com.dnnr.DNNR_tier3.models.food;

import java.util.LinkedList;
import java.util.List;

public class Recipe
{
    private String name;
    private List<Ingredient> recipeIngredient;

    public Recipe()
    {
        recipeIngredient = new LinkedList<>();
    }

    public String getName()
    {
        return name;
    }

    public List<Ingredient> getRecipeIngredient()
    {
        return recipeIngredient;
    }
}
