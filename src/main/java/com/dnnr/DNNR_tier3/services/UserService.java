package com.dnnr.DNNR_tier3.services;

import com.dnnr.DNNR_tier3.dataAccess.IDao;
import com.dnnr.DNNR_tier3.models.DatabaseCountContainer;
import com.dnnr.DNNR_tier3.models.GuestUser;
import com.dnnr.DNNR_tier3.models.RegisteredUser;
import com.dnnr.DNNR_tier3.models.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService implements IUserService
{
    @Resource IDao dao;

   /* @Override public List<User> getAllUsers()
    {
        return dao.getAllUsers();
    }*/

    @Override public RegisteredUser getUserByUsername(String username)
    {
        return dao.getUserByUsername(username);
    }

    @Override public void setUser(RegisteredUser registeredUser)
    {
    dao.setUser(registeredUser);
    }

    @Override public DatabaseCountContainer getDatabaseCount()
    {
        int animalCount = dao.getAnimalCount();
        int colourCount = dao.getColourCount();

        return new DatabaseCountContainer(animalCount, colourCount);
    }

    @Override public User createGuestUser(int colourId, int animalId)
    {
        String animal = dao.getAnimal(animalId);
        String colour = dao.getColour(colourId);

        return new GuestUser(colour + " " + animal);
    }

}
