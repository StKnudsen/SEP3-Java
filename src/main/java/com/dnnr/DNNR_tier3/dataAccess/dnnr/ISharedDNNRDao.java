package com.dnnr.DNNR_tier3.dataAccess.dnnr;

import java.util.Dictionary;

public interface ISharedDNNRDao
{
  /*
   *  Used by both admins and registered users
   */
  Dictionary<Integer, String> getFoodGroupList();
  Dictionary<Integer, String> getIngredientList();
}
