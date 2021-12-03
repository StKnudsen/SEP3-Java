package com.dnnr.DNNR_tier3.dataAccess.admin;

import com.dnnr.DNNR_tier3.models.food.Recipe;

import java.util.Dictionary;

public interface IAdminDao
{
  boolean addIngredient(String ingredientName, int foodgroup);
  boolean addIngredientsToFoodgroup(int ingredientId,
      int foodgroup);
  boolean addRecipe(Recipe recipe);
   Dictionary<Integer, String> getFoodgroupList();
   Dictionary<Integer, String> getIngredientList();
   Dictionary<Integer, String> getUnitList();
  Dictionary<Integer, String> getRecipeList();
}
