package com.dnnr.DNNR_tier3.services.restaurateur;

import com.dnnr.DNNR_tier3.dataAccess.restaurateur.IRestaurateurDao;
import com.dnnr.DNNR_tier3.models.restaurant.Dish;
import com.dnnr.DNNR_tier3.models.user.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class RestaurateurService implements IRestaurateurService{
    @Resource
    IRestaurateurDao restaurateurDao;

    @Override
    public boolean addDish(Dish dish) {
        return restaurateurDao.addDish(dish);
    }

    @Override
    public List<Dish> getDishList(int restaurantId) {
        return restaurateurDao.getDishList(restaurantId);
    }
}
