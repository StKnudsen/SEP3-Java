package com.dnnr.DNNR_tier3.dataAccess.admin;

import com.dnnr.DNNR_tier3.models.restaurant.Address;
import com.dnnr.DNNR_tier3.models.restaurant.Restaurant;
import com.dnnr.DNNR_tier3.models.food.Recipe;

import java.util.Dictionary;
import java.util.List;

public interface IAdminDao
{
  boolean addIngredient(String ingredientName, int foodGroup);
  boolean addIngredientToFoodGroup(int ingredientId, int foodGroup);
  boolean addFoodGroup(String foodGroupName);

    boolean addIngredientsToFoodgroup(int ingredientId, int foodgroup);
    boolean addRecipe(Recipe recipe);
    boolean addRestaurant(Restaurant restaurant);
    Dictionary<Integer, String> getUnitList();
    Dictionary<Integer, String> getRecipeList();
    List<Restaurant> getRestaurantList();
    List<Address> getAddressList();
    Address getAddressById(int addressId);

}
