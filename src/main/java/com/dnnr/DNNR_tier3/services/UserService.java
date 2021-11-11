package com.dnnr.DNNR_tier3.services;

import com.dnnr.DNNR_tier3.dataAccess.IDAO;
import com.dnnr.DNNR_tier3.models.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService implements IUserService
{
    @Resource IDAO dao;

    @Override public List<User> getAllUsers()
    {
        return dao.getAllUsers();
    }

    @Override public User getUserById(int userId)
    {
        return dao.getUserById(userId);
    }

    @Override public void setUser(User user)
    {
    dao.setUser(user);
    }
}
