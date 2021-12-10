package com.dnnr.DNNR_tier3.controllers.admin;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.models.food.Recipe;

import java.util.Dictionary;

public interface IAdminController
{
 boolean addIngredient(CustomPair ingredient);
 boolean addFoodGroup(String foodGroupName);
 boolean addRecipe(Recipe recipe);
  Dictionary<Integer, String> getFoodgroupList();
  Dictionary<Integer, String> getIngredientList();
  Dictionary<Integer, String> getUnitList();
  Dictionary<Integer,String> getRecipeList();

}
