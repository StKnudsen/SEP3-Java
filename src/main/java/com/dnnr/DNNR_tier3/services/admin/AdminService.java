package com.dnnr.DNNR_tier3.services.admin;
import com.dnnr.DNNR_tier3.dataAccess.admin.IAdminDao;
import com.dnnr.DNNR_tier3.models.food.Recipe;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Dictionary;

@Component
public class AdminService implements IAdminService
{
  @Resource IAdminDao adminDao;

  @Override public boolean addIngredient(String ingredientName,
      int foodgroup)
  {
   return  adminDao.addIngredient(ingredientName, foodgroup);
  }

  @Override public boolean addRecipe(Recipe recipe)
  {
    return adminDao.addRecipe(recipe);
  }

  @Override public Dictionary<Integer, String> getFoodgroupList()
  {
    return  adminDao.getFoodgroupList();
  }

  @Override public Dictionary<Integer, String> getIngredientList()
  {
    return adminDao.getIngredientList();
  }

  @Override public Dictionary<Integer, String> getUnitList()
  {
    return adminDao.getUnitList();
  }

  @Override public Dictionary<Integer, String> getRecipeList()
  {
    return adminDao.getRecipeList();
  }
}
