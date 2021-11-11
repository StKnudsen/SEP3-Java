package com.dnnr.DNNR_tier3.services;

import com.dnnr.DNNR_tier3.models.User;

import java.util.List;

public interface IUserService
{
    List<User> getAllUsers();
    User getUserById(int userId);
    void setUser(User user);
}
