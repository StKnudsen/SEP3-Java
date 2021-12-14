package com.dnnr.DNNR_tier3.services.user;

import com.dnnr.DNNR_tier3.dataAccess.authentication.IAuthenticationDao;
import com.dnnr.DNNR_tier3.dataAccess.user.IUserDao;
import com.dnnr.DNNR_tier3.models.ColourAnimalCount;
import com.dnnr.DNNR_tier3.models.user.GuestUser;
import com.dnnr.DNNR_tier3.models.user.RegisteredUser;
import com.dnnr.DNNR_tier3.models.user.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Dictionary;

@Component public class UserService implements IUserService
{
  @Resource IAuthenticationDao authenticationDao;
  @Resource IUserDao userDao;

  @Override public RegisteredUser getUserByUsername(String username)
  {
    RegisteredUser user = authenticationDao.getUserByUsername(username);
    return user;
  }

  @Override public void setUser(RegisteredUser registeredUser)
  {
    authenticationDao.setUser(registeredUser);
  }

  @Override public ColourAnimalCount getDatabaseCount()
  {
    int animalCount = authenticationDao.getAnimalCount();
    int colourCount = authenticationDao.getColourCount();

    return new ColourAnimalCount(animalCount, colourCount);
  }

  @Override public User createGuestUser(int colourId, int animalId)
  {
    String animal = authenticationDao.getAnimal(animalId);
    String colour = authenticationDao.getColour(colourId);

    return new GuestUser(colour + " " + animal);
  }
  
  /*
   *  Methods for get and set Allergies for users
   */
  @Override public Dictionary<Integer, String> getAllergyFoodGroupList(
      int userId)
  {
    return userDao.getAllergyFoodGroupList(userId);
  }

  @Override public Dictionary<Integer, String> getAllergyIngredientList(
      int userId)
  {
    return userDao.getAllergyIngredientList(userId);
  }

  @Override public boolean SetUserAllergyFoodGroup(int userId, int foodGroupId)
  {
    return userDao.SetUserAllergyFoodGroup(userId, foodGroupId);
  }

  @Override public boolean SetUserAllergyIngredient(int userId, int ingredient)
  {
    return userDao.SetUserAllergyIngredient(userId, ingredient);
  }
}
