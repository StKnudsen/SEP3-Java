package com.dnnr.DNNR_tier3.dataAccess.general;

import java.util.Dictionary;

public interface IGeneralDao
{
  Dictionary<Integer, String> getFoodgroupList();
  Dictionary<Integer, String> getIngredientList();
}
