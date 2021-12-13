package com.dnnr.DNNR_tier3.services.dnnr;

import java.util.Dictionary;

public interface ISharedDNNRService
{
  /*
   *  Used by both admins and registered users
   */
  Dictionary<Integer, String> getFoodGroupList();
  Dictionary<Integer, String> getIngredientList();
}
