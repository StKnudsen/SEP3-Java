package com.dnnr.DNNR_tier3.controllers.admin;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

public interface IAdminController
{
  public boolean addIngredient(String ingredientName,
      int foodgroup);
}
