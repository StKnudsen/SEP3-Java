package com.dnnr.DNNR_tier3.controllers.user;

import com.dnnr.DNNR_tier3.models.ColourAnimalCount;
import com.dnnr.DNNR_tier3.models.user.RegisteredUser;
import com.dnnr.DNNR_tier3.models.user.User;

import java.util.Dictionary;
import java.util.List;

public interface IUserController
{
    //List<User> getAllUsers();
    User getUserByUsername(String username);
    void setUser(RegisteredUser newRegisteredUser);
    User getGuestUser(int colourId, int animalId);
    ColourAnimalCount getDatabaseCount();

    //  For allergy registration
    //Ilist<> getAllergyFoodGroupList(int userId);
    //Dictionary<Integer, String> getAllergyIngredientList(int userId);
}