package com.dnnr.DNNR_tier3.controllers.user;

import com.dnnr.DNNR_tier3.models.ColourAnimalCount;
import com.dnnr.DNNR_tier3.models.user.RegisteredUser;
import com.dnnr.DNNR_tier3.models.user.User;
import com.dnnr.DNNR_tier3.services.user.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController implements IUserController
{
    @Resource IUserService userService;

    @GetMapping(value = "/user/{username}") public User getUserAsync(@PathVariable String username)
    {
        return userService.getUserByUsername(username);
    }

    @PostMapping(value = "/user") public void setUser(@RequestBody RegisteredUser newRegisteredUser)
    {
        userService.setUser(newRegisteredUser);
    }

    @GetMapping(value = "/user/guestUser") public User getGuestUserAsync(@RequestParam int colourId,@RequestParam int animalId)
    {
        return userService.createGuestUser(colourId, animalId);
    }

    @GetMapping(value = "/user/guestColoursAnimals") public ColourAnimalCount getColourAnimalCountAsync()
    {
        return userService.getDatabaseCount();
    }
}
