package com.dnnr.DNNR_tier3.services;

import com.dnnr.DNNR_tier3.models.ColourAnimalCount;
import com.dnnr.DNNR_tier3.models.RegisteredUser;
import com.dnnr.DNNR_tier3.models.User;

public interface IUserService
{
   // List<User> getAllUsers();
    User getUserByUsername(String username);
    void setUser(RegisteredUser registeredUser);
    ColourAnimalCount getDatabaseCount();
    User createGuestUser(int colourId, int animalId);
}
