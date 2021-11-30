package com.dnnr.DNNR_tier3.services.admin;

import java.util.Dictionary;

public interface IAdminService
{
  boolean addIngredient(String ingredientName, int foodgroup);
  public Dictionary<Integer, String> getFoodgroupList();
  public Dictionary<Integer, String> getIngredientList();
}
