package com.dnnr.DNNR_tier3.controllers.group;

import com.dnnr.DNNR_tier3.models.CustomPair;

import java.util.List;

public interface IGroupController
{
  List<CustomPair> getShuffledRecipes();
  List<CustomPair> getShuffledRestaurants();
}
