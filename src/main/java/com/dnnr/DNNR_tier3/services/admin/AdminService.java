package com.dnnr.DNNR_tier3.services.admin;
import com.dnnr.DNNR_tier3.dataAccess.admin.IAdminDao;
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

  @Override public Dictionary<Integer, String> getFoodgroupList()
  {
    //TODO
    return null;
  }

  @Override public Dictionary<Integer, String> getIngredientList()
  {
    //TODO
    return null;
  }
}
