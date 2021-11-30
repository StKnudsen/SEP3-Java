package com.dnnr.DNNR_tier3.controllers.admin;

import com.dnnr.DNNR_tier3.services.admin.IAdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Dictionary;

@RestController
public class AdminController implements IAdminController
{
  @Resource IAdminService adminService;

  @PostMapping(value = "/ingredient")
  @Override public boolean addIngredient(String ingredientName,
      int foodgroup)
  {
    return adminService.addIngredient(ingredientName, foodgroup);
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
}
