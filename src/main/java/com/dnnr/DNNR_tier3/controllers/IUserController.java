package com.dnnr.DNNR_tier3.controllers;

import com.dnnr.DNNR_tier3.models.ColourAnimalCount;
import com.dnnr.DNNR_tier3.models.RegisteredUser;
import com.dnnr.DNNR_tier3.models.User;

public interface IUserController
{
//    List<User> getAllUsers();
    User getUserByUsername(String username);
    void setUser(RegisteredUser newRegisteredUser);
    User getGuestUser(int colourId, int animalId);
    ColourAnimalCount getDatabaseCount();
}
