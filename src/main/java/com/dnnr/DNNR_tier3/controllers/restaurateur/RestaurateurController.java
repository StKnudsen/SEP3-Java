package com.dnnr.DNNR_tier3.controllers.restaurateur;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.models.restaurant.Dish;
import com.dnnr.DNNR_tier3.models.restaurant.Restaurant;
import com.dnnr.DNNR_tier3.models.user.User;
import com.dnnr.DNNR_tier3.services.restaurateur.IRestaurateurService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurateurController implements IRestaurateurController {

    @Resource
    IRestaurateurService restaurateurService;

    @PostMapping(value = "/adddish")
    @Override
    public boolean addDishAsync(@RequestBody Dish dish) {
         return restaurateurService.addDish(dish);
    }

    @GetMapping(value = "/dishes")
    @Override
    public List<Dish> getDishListAsync(int restaurantId) {
        return restaurateurService.getDishList(restaurantId);
    }

    @GetMapping(value = "/restaurants/{restaurateurId}")
    @Override
    public List<Restaurant> getRestaurantsFromRestaurateurIdAsync(@PathVariable int restaurateurId) {
        return restaurateurService.getRestaurantsFromRestaurateurId(restaurateurId);
    }
}
