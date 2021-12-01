package com.dnnr.DNNR_tier3.controllers.admin;

import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Dictionary;

public interface IAdminController
{
 boolean addIngredient(Pair<Integer, String> ingredient);
  Dictionary<Integer, String> getFoodgroupList();
  Dictionary<Integer, String> getIngredientList();
}
