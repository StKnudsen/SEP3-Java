package com.dnnr.DNNR_tier3.services.admin;

import com.dnnr.DNNR_tier3.models.Recipe;

import java.util.Dictionary;

public interface IAdminService
{
  boolean addIngredient(String ingredientName, int foodgroup);
  boolean addRecipe(Recipe recipe);
   Dictionary<Integer, String> getFoodgroupList();
   Dictionary<Integer, String> getIngredientList();
   Dictionary<Integer, String> getUnitList();
   Dictionary<Integer, String> getRecipeList();
}