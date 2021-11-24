package com.dnnr.DNNR_tier3.controllers;

import com.dnnr.DNNR_tier3.models.DatabaseCountContainer;
import com.dnnr.DNNR_tier3.models.RegisteredUser;
import com.dnnr.DNNR_tier3.models.User;
import com.dnnr.DNNR_tier3.services.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @PostMapping(value = "/user") public void setUser(@RequestBody RegisteredUser newRegisteredUser)
    {
        userService.setUser(newRegisteredUser);
    }

    @GetMapping(value = "/user/guestUser") public User getGuestUser(@RequestParam int colourId,@RequestParam int animalId)
    {
        return userService.createGuestUser(colourId, animalId);
    }

    @GetMapping(value = "/user/guestColoursAnimals") public DatabaseCountContainer getDatabaseCount()
    {
        return userService.getDatabaseCount();
    }
}
