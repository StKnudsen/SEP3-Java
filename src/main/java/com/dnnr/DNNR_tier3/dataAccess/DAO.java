package com.dnnr.DNNR_tier3.dataAccess;

import com.dnnr.DNNR_tier3.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAO implements IDAO
{
    @Override public User getUserById(int userId)
    {
        return null;
    }

    @Override public User setUser(User user)
    {
        return null;
    }

    @Override public List<User> getAllUsers()
    {
        return null;
    }
}
