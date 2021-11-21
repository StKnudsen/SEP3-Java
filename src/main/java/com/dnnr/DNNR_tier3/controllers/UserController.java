package com.dnnr.DNNR_tier3.controllers;

import com.dnnr.DNNR_tier3.models.DatabaseCountContainer;
import com.dnnr.DNNR_tier3.models.User;
import com.dnnr.DNNR_tier3.services.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController implements IUserController
{
    @Resource IUserService userService;

    /*@GetMapping(value = "/user") public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }*/

    @GetMapping(value = "/user/{username}") public User getUserByUsername(@PathVariable String username)
    {
        return userService.getUserByUsername(username);
    }

    @PostMapping(value = "/user") public void setUser(@RequestBody User newUser)
    {
        userService.setUser(newUser);
    }

    @GetMapping(value = "/user/guestUserCount") public DatabaseCountContainer getDatabaseCount()
    {
        return userService.getDatabaseCount();
    }
}
