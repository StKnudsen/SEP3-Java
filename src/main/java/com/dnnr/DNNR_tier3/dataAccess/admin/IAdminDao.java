package com.dnnr.DNNR_tier3.dataAccess.admin;

import java.util.List;

public interface IAdminDao
{
  boolean addIngredient(String ingredientName, int foodgroup);
  boolean addIngredientsToFoodgroups(int ingredientId,
      int foodgroup);
}
