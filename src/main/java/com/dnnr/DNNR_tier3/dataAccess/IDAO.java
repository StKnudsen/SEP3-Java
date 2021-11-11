package com.dnnr.DNNR_tier3.dataAccess;

import com.dnnr.DNNR_tier3.models.User;

import java.util.List;

public interface IDAO
{
     User getUserByUsername(String username);
     User setUser(User user);
     List<User> getAllUsers();
}
