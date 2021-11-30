package com.dnnr.DNNR_tier3.controllers.admin;

import java.util.Dictionary;

public interface IAdminController
{
  public boolean addIngredient(String ingredientName,
      int foodgroup);
  Dictionary<Integer, String> getFoodgroupList();
  Dictionary<Integer, String> getIngredientList();
}
