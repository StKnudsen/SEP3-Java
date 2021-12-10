package com.dnnr.DNNR_tier3.controllers.restaurateur;

import com.dnnr.DNNR_tier3.models.CustomPair;
import com.dnnr.DNNR_tier3.models.restaurant.Dish;
import com.dnnr.DNNR_tier3.models.user.User;
import com.dnnr.DNNR_tier3.services.restaurateur.IRestaurateurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurateurController implements IRestaurateurController {

    @Resource
    IRestaurateurService restaurateurService;

    @PostMapping(value = "/adddish")
    @Override
    public boolean addDish(CustomPair dish) {
        int restaurantId = dish.getKey();
        String DishNameAndDescription = dish.getValue();
        String[] seperate = DishNameAndDescription.split(";",2);
        String DishName = seperate[0];
        String DishDescription = seperate[1];
        Dish newDish = new Dish(DishName,DishDescription,restaurantId);
         return restaurateurService.addDish(newDish);
    }

    @GetMapping(value = "/dishes")
    @Override
    public List<Dish> getDishList(int restaurantId) {
        return restaurateurService.getDishList(restaurantId);
    }
}
