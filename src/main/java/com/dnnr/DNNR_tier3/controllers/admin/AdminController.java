package com.dnnr.DNNR_tier3.controllers.admin;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.services.admin.IAdminService;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Dictionary;
import java.util.TreeMap;

@RestController
//@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
public class AdminController implements IAdminController
{
  @Resource IAdminService adminService;

  @PostMapping(value = "/ingredients")
  @Override public boolean addIngredient(
      @RequestBody CustomPair ingredient)
  {
    System.out.println("It me " + ingredient.getValue());
    int foodgroup =ingredient.getKey();
    String ingredientName = ingredient.getValue();
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
