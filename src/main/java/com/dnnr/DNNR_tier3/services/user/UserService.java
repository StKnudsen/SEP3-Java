package com.dnnr.DNNR_tier3.services.user;

import com.dnnr.DNNR_tier3.dataAccess.IDao;
import com.dnnr.DNNR_tier3.models.ColourAnimalCount;
import com.dnnr.DNNR_tier3.models.user.GuestUser;
import com.dnnr.DNNR_tier3.models.user.RegisteredUser;
import com.dnnr.DNNR_tier3.models.user.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component public class UserService implements IUserService
{
  @Resource IDao dao;

   /* @Override public List<User> getAllUsers()
    {
        return dao.getAllUsers();
    }*/

  @Override public RegisteredUser getUserByUsername(String username)
  {
    RegisteredUser user = dao.getUserByUsername(username);
    return user;
  }

  @Override public void setUser(RegisteredUser registeredUser)
  {
    dao.setUser(registeredUser);
  }

  @Override public ColourAnimalCount getDatabaseCount()
  {
    int animalCount = dao.getAnimalCount();
    int colourCount = dao.getColourCount();

    return new ColourAnimalCount(animalCount, colourCount);
  }

  @Override public User createGuestUser(int colourId, int animalId)
  {
    String animal = dao.getAnimal(animalId);
    String colour = dao.getColour(colourId);

    return new GuestUser(colour + " " + animal);
  }

}
