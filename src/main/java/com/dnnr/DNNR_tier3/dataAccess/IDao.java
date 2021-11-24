package com.dnnr.DNNR_tier3.dataAccess;

import com.dnnr.DNNR_tier3.models.RegisteredUser;

public interface IDao
{
     RegisteredUser getUserByUsername(String username);
     Boolean setUser(RegisteredUser registeredUser);
     int getAnimalCount();
     int getColourCount();
     String getAnimal(int id);
     String getColour(int id);
     //List<User> getAllUsers();
}
