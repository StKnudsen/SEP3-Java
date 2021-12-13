package com.dnnr.DNNR_tier3.dataAccess.user;

import java.util.Dictionary;

public interface IUserDao
{
  //  For allergy registration
  Dictionary<Integer, String> getAllergyFoodGroupList(int userId);
  Dictionary<Integer, String> getAllergyIngredientList(int userId);
  boolean SetUserAllergyFoodGroup(int userId, int foodGroupId);
  boolean SetUserAllergyIngredient(int userId, int ingredient);
}
