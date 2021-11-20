package com.dnnr.DNNR_tier3.services;

import com.dnnr.DNNR_tier3.dataAccess.IDao;
import com.dnnr.DNNR_tier3.models.DatabaseCountContainer;
import com.dnnr.DNNR_tier3.models.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService implements IUserService
{
    @Resource IDao dao;

   /* @Override public List<User> getAllUsers()
    {
        return dao.getAllUsers();
    }*/

    @Override public User getUserByUsername(String username)
    {
        return dao.getUserByUsername(username);
    }

    @Override public void setUser(User user)
    {
    dao.setUser(user);
    }

    @Override public DatabaseCountContainer getDatabaseCount()
    {
        int animalCount = dao.getAnimalCount();
        int colourCount = dao.getColourCount();

        return new DatabaseCountContainer(animalCount, colourCount);
    }

}
