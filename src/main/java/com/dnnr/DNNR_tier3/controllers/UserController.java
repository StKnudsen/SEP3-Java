package com.dnnr.DNNR_tier3.controllers;

import com.dnnr.DNNR_tier3.models.User;
import com.dnnr.DNNR_tier3.services.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController implements IUserController
{
    @Resource IUserService userService;

    @GetMapping(value = "/user") List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

}
