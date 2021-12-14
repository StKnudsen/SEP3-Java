package com.dnnr.DNNR_tier3.controllers.group;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.services.group.IGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GroupController implements IGroupController
{
  @Resource IGroupService groupService;

  @PostMapping(value = "/group/recipes") public List<CustomPair> getShuffledRecipesAsync(@RequestBody List<String> allergies)
  {
    return groupService.getShuffledRecipes(allergies);
  }

  @GetMapping(value = "/group/restaurants") public List<CustomPair> getShuffledRestaurantsAsync()
  {
    return groupService.getShuffledRestaurants();
  }
}
