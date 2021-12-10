package com.dnnr.DNNR_tier3.controllers.admin;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.models.restaurant.Address;
import com.dnnr.DNNR_tier3.models.restaurant.Restaurant;
import com.dnnr.DNNR_tier3.models.food.Recipe;

import java.util.Dictionary;
import java.util.List;

public interface IAdminController
{
 boolean addIngredient(CustomPair ingredient);
 boolean addFoodGroup(String foodGroupName);
 boolean addRecipe(Recipe recipe);
 boolean addRestaurant(Restaurant restaurant);

 Dictionary<Integer, String> getFoodgroupList();
  Dictionary<Integer, String> getIngredientList();
  Dictionary<Integer, String> getUnitList();
  Dictionary<Integer,String> getRecipeList();
 List<Restaurant> getRestaurantList();
 List<Address> getAddressList();
 Address getAddressById(int addressId);
}
