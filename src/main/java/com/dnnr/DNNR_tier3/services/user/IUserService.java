package com.dnnr.DNNR_tier3.services.user;

import com.dnnr.DNNR_tier3.models.ColourAnimalCount;
import com.dnnr.DNNR_tier3.models.user.RegisteredUser;
import com.dnnr.DNNR_tier3.models.user.User;

import java.util.Dictionary;

public interface IUserService
{
    User getUserByUsername(String username);
    void setUser(RegisteredUser registeredUser);
    ColourAnimalCount getDatabaseCount();
    User createGuestUser(int colourId, int animalId);

    //  For allergy registration
    Dictionary<Integer, String> getAllergyFoodGroupList(int userId);
    Dictionary<Integer, String> getAllergyIngredientList(int userId);
    boolean SetUserAllergyFoodGroup(int userId, int foodGroupId);
    boolean SetUserAllergyIngredient(int userId, int ingredient);
}
