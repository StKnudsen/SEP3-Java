package com.dnnr.DNNR_tier3.services.admin;

import com.dnnr.DNNR_tier3.models.restaurant.Address;
import com.dnnr.DNNR_tier3.models.restaurant.Restaurant;
import com.dnnr.DNNR_tier3.models.food.Recipe;

import java.util.Dictionary;
import java.util.List;

public interface IAdminService
{
  boolean addIngredient(String ingredientName, int foodgroup);
  boolean addFoodGroup(String foodGroupName);
  boolean addRecipe(Recipe recipe);
  boolean addRestaurant(Restaurant restaurant);

  Dictionary<Integer, String> getUnitList();
  Dictionary<Integer, String> getRecipeList();
  List<Restaurant> getRestaurantList();
  List<Address> getAddressList();
  Address getAddressById(int addressId);

}
