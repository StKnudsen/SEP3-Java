package com.dnnr.DNNR_tier3.controllers.admin;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.models.restaurant.Address;
import com.dnnr.DNNR_tier3.models.restaurant.Restaurant;
import com.dnnr.DNNR_tier3.models.food.Recipe;

import java.util.Dictionary;
import java.util.List;

public interface IAdminController
{
  boolean addIngredientAsync(CustomPair ingredient);
  boolean addFoodGroupAsync(String foodGroupName);
  boolean addRecipeAsync(Recipe recipe);
  boolean addRestaurantAsync(Restaurant restaurant);
  Dictionary<Integer, String> getUnitListAsync();
  Dictionary<Integer, String> getRecipeListAsync();
  Dictionary<Integer, String> getUsersAndRestaurateurListAsync();
  List<Restaurant> getRestaurantListAsync();
  List<Address> getAddressListAsync();
  Address getAddressByIdAsync(int addressId);
}
