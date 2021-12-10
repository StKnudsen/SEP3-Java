package com.dnnr.DNNR_tier3.controllers.dnnr;

import java.util.Dictionary;

public interface ISharedDNNRController
{
  /*
   *  Used by both admins and registered users
   */

  Dictionary<Integer, String> getFoodGroupList();
  Dictionary<Integer, String> getIngredientList();
}
