package com.dnnr.DNNR_tier3.controllers.restaurateur;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.models.restaurant.Dish;
import com.dnnr.DNNR_tier3.models.user.User;

import java.util.List;

public interface IRestaurateurController {
    boolean addDish(CustomPair dish);
    List<Dish> getDishList(int restaurantId);
}
