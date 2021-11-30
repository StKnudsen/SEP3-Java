package com.dnnr.DNNR_tier3.controllers.admin;

import com.dnnr.DNNR_tier3.services.admin.IAdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminController implements IAdminController
{
  @Resource IAdminService adminService;

  @PostMapping(value = "/ingredient") public boolean addIngredient(String ingredientName,
      int foodgroup)
  {
    return adminService.addIngredient(ingredientName, foodgroup);
  }
}
