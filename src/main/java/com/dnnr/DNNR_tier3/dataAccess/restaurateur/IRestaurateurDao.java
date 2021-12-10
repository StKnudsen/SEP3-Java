package com.dnnr.DNNR_tier3.dataAccess.restaurateur;

import com.dnnr.DNNR_tier3.models.restaurant.Dish;
import com.dnnr.DNNR_tier3.models.user.User;

import java.util.List;

public interface IRestaurateurDao {
    boolean addDish(Dish dish);
    List<Dish> getDishList(int restaurantId);

}
