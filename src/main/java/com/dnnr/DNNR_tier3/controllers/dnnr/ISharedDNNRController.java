package com.dnnr.DNNR_tier3.controllers.dnnr;

import java.util.Dictionary;

public interface ISharedDNNRController
{
  Dictionary<Integer, String> getFoodGroupList();
  Dictionary<Integer, String> getIngredientList();
}
