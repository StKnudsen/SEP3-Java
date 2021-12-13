package com.dnnr.DNNR_tier3.dataAccess;

import com.dnnr.DNNR_tier3.models.user.RegisteredUser;
import com.dnnr.DNNR_tier3.models.user.User;

import java.util.List;

public interface IDao
{
  RegisteredUser getUserByUsername(String username);
  Boolean setUser(RegisteredUser registeredUser);
  List<User> getAllUsers();
  int getAnimalCount();
  int getColourCount();
  String getAnimal(int id);
  String getColour(int id);
}
