package com.dnnr.DNNR_tier3.services.group;

import com.dnnr.DNNR_tier3.models.CustomPair;

import java.util.List;

public interface IGroupService
{
  List<CustomPair> getShuffledRecipes();
  List<CustomPair> getShuffledRestaurants();
}
