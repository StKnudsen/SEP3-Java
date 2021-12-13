package com.dnnr.DNNR_tier3.dataAccess.authentication;

import com.dnnr.DNNR_tier3.models.user.RegisteredUser;

public interface IAuthenticationDao
{
  RegisteredUser getUserByUsername(String username);
  Boolean setUser(RegisteredUser registeredUser);
  int getAnimalCount();
  int getColourCount();
  String getAnimal(int id);
  String getColour(int id);
}