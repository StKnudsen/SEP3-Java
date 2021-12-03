package com.dnnr.DNNR_tier3.controllers.group;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.services.group.IGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GroupController implements IGroupController
{
  @Resource IGroupService groupService;

  @GetMapping(value = "/group/recipes") public List<CustomPair> getShuffledRecipes()
  {
    return groupService.getShuffledRecipes();
  }

  @GetMapping(value = "/group/restaurants") public List<CustomPair> getShuffledRestaurants()
  {
    return groupService.getShuffledRestaurants();
  }
}
