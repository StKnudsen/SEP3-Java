package com.dnnr.DNNR_tier3.controllers.admin;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.models.Recipe;
import com.dnnr.DNNR_tier3.models.RecipeIngredient;
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
  @Override public boolean addIngredient(
      @RequestBody CustomPair ingredient)
  {
    System.out.println("It me " + ingredient.getValue());
    int foodgroup =ingredient.getKey();
    String ingredientName = ingredient.getValue();
    return adminService.addIngredient(ingredientName, foodgroup);
  }
  @PostMapping(value = "/addrecipe")
  @Override public boolean addRecipe(
      @RequestBody Recipe recipe)
  {
    List<RecipeIngredient> recipeIngredientsList = recipe.getRecipeIngredient();

    System.out.println("It me opskrift " + recipe.getName() + " med ingrediensliste " + recipeIngredientsList.size());
    return adminService.addRecipe(recipe);
  }

  @GetMapping(value = "/foodgroups")
  @Override public Dictionary<Integer, String> getFoodgroupList()
  {
    return adminService.getFoodgroupList();
  }

  @GetMapping(value = "/ingredients")
  @Override public Dictionary<Integer, String> getIngredientList()
  {
    return adminService.getIngredientList();
  }

  @GetMapping(value = "/units")
  @Override public Dictionary<Integer, String> getUnitList()
  {
    return adminService.getUnitList();
  }

  @GetMapping(value = "/recipes")
  @Override public Dictionary<Integer, String> getRecipeList()
  {
    return adminService.getRecipeList();
  }
}
