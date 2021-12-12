package com.dnnr.DNNR_tier3.controllers.user;

import com.dnnr.DNNR_tier3.models.ColourAnimalCount;
import com.dnnr.DNNR_tier3.models.user.RegisteredUser;
import com.dnnr.DNNR_tier3.models.user.User;

public interface IUserController
{
  //    List<User> getAllUsers();
  void setUser(RegisteredUser newRegisteredUser);
  User getUserByUsername(String username);
  User getGuestUser(int colourId, int animalId);
  ColourAnimalCount getDatabaseCount();
}
