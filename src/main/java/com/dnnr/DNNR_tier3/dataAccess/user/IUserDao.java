package com.dnnr.DNNR_tier3.dataAccess.user;

import java.util.Dictionary;

public interface IUserDao
{
  //  For allergy registration
  Dictionary<Integer, String> getAllergyFoodGroupList(int userId);
  Dictionary<Integer, String> getAllergyIngredientList(int userId);
  boolean setUserAllergyFoodGroup(int userId, int foodGroupId);
  boolean setUserAllergyIngredient(int userId, int ingredient);
}
