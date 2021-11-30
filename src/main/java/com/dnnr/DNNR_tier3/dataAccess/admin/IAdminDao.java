package com.dnnr.DNNR_tier3.dataAccess.admin;

import java.util.Dictionary;

public interface IAdminDao
{
  boolean addIngredient(String ingredientName, int foodgroup);
  boolean addIngredientsToFoodgroup(int ingredientId,
      int foodgroup);
  public Dictionary<Integer, String> getFoodgroupList();
  public Dictionary<Integer, String> getIngredientList();
}
