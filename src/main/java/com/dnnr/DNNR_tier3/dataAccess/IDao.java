package com.dnnr.DNNR_tier3.dataAccess;

import com.dnnr.DNNR_tier3.models.DatabaseCountContainer;
import com.dnnr.DNNR_tier3.models.User;

import java.util.List;

public interface IDao
{
     User getUserByUsername(String username);
     Boolean setUser(User user);
     int getAnimalCount();
     int getColourCount();
     //List<User> getAllUsers();
}
