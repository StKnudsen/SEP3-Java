package com.dnnr.DNNR_tier3.dataAccess.group;

import com.dnnr.DNNR_tier3.models.CustomPair;

import java.util.List;

public interface IGroupDao
{
  List<CustomPair> getShuffledRecipes(String ingredients, String foodGroups);
  List<CustomPair> getShuffledRestaurants();
}
