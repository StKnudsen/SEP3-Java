package com.dnnr.DNNR_tier3.controllers.admin;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.models.restaurant.Address;
import com.dnnr.DNNR_tier3.models.restaurant.Restaurant;
import com.dnnr.DNNR_tier3.models.food.Recipe;
import com.dnnr.DNNR_tier3.models.food.Ingredient;
import com.dnnr.DNNR_tier3.services.admin.IAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Dictionary;
import java.util.List;

@RestController
//@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
public class AdminController implements IAdminController
{
  @Resource IAdminService adminService;

  @PostMapping(value = "/addingredients")
  @Override public boolean addIngredientAsync(
      @RequestBody CustomPair ingredient)
  {
    System.out.println("It me " + ingredient.getValue());
    int foodgroup = ingredient.getKey();
    String ingredientName = ingredient.getValue();
    return adminService.addIngredient(ingredientName, foodgroup);
  }

  @PostMapping(value = "/addfoodgroup")
  @Override public boolean addFoodGroupAsync(@RequestParam String foodGroupName)
  {
    return adminService.addFoodGroup(foodGroupName);
  }

  @PostMapping(value = "/addrecipe")
  @Override public boolean addRecipeAsync(
      @RequestBody Recipe recipe)
  {
    List<Ingredient> recipeIngredientsList = recipe.getRecipeIngredient();
    System.out.println("It me opskrift " + recipe.getName() + " med ingrediensnavn " + recipeIngredientsList.get(0).getIngredientName());
    return adminService.addRecipe(recipe);
  }

  @PostMapping(value = "/addrestaurant")
  @Override public boolean addRestaurantAsync(@RequestBody Restaurant restaurant)
  {
    System.out.println("AdminController i addRestaurant");

    return adminService.addRestaurant(restaurant);
  }

  @GetMapping(value = "/units")
  @Override public Dictionary<Integer, String> getUnitListAsync()
  {
    return adminService.getUnitList();
  }

  @GetMapping(value = "/recipes")
  @Override public Dictionary<Integer, String> getRecipeListAsync()
  {
    return adminService.getRecipeList();
  }

  @GetMapping(value = "/restaurants")
  @Override public List<Restaurant> getRestaurantListAsync()
  {
    return adminService.getRestaurantList();
  }
  @GetMapping(value = "/address")
  @Override public List<Address> getAddressListAsync()
  {
    return adminService.getAddressList();
  }

  @GetMapping(value = "/address/{addressId}")
  @Override public Address getAddressByIdAsync(int addressId)
  {
    return adminService.getAddressById(addressId);
  }

}
