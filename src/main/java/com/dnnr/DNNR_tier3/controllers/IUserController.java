package com.dnnr.DNNR_tier3.controllers;

import com.dnnr.DNNR_tier3.models.User;

import java.util.List;

public interface IUserController
{
//    List<User> getAllUsers();
    User getUserByUsername(String username);
    void setUser(User newUser);
}
