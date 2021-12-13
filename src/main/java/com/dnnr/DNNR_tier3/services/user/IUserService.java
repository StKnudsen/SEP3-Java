package com.dnnr.DNNR_tier3.services.user;

import com.dnnr.DNNR_tier3.models.ColourAnimalCount;
import com.dnnr.DNNR_tier3.models.user.RegisteredUser;
import com.dnnr.DNNR_tier3.models.user.User;

import java.util.Dictionary;

import java.util.List;

public interface IUserService
{
   // List<User> getAllUsers();
    User getUserByUsername(String username);
    void setUser(RegisteredUser registeredUser);
    ColourAnimalCount getDatabaseCount();
    User createGuestUser(int colourId, int animalId);
}
