package com.dnnr.DNNR_tier3.services.dnnr;

import java.util.Dictionary;

public interface ISharedDNNRService
{

  Dictionary<Integer, String> getFoodGroupList();
  Dictionary<Integer, String> getIngredientList();
}
