package com.dnnr.DNNR_tier3.controllers.user;

import com.dnnr.DNNR_tier3.models.ColourAnimalCount;
import com.dnnr.DNNR_tier3.models.user.RegisteredUser;
import com.dnnr.DNNR_tier3.models.user.User;
import com.dnnr.DNNR_tier3.services.user.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Dictionary;

@RestController public class UserController implements IUserController
{
  @Resource IUserService userService;

  @GetMapping(value = "/user/{username}") @Override public User getUserAsync(
      @PathVariable String username)
  {
    return userService.getUserByUsername(username);
  }

  @PostMapping(value = "/user") @Override public void setUser(
      @RequestBody RegisteredUser newRegisteredUser)
  {
    userService.setUser(newRegisteredUser);
  }

  @GetMapping(value = "/user/guestUser") @Override public User getGuestUserAsync(
      @RequestParam int colourId, @RequestParam int animalId)
  {
    return userService.createGuestUser(colourId, animalId);
  }

  @GetMapping(value = "/user/guestColoursAnimals") @Override public ColourAnimalCount getColourAnimalCountAsync()
  {
    return userService.getDatabaseCount();
  }

  /*
   *  Methods for get and set Allergies for users
   */
  @GetMapping(value = "/allergy/{userId}/foodgroup") @Override public Dictionary<Integer, String> getAllergyFoodGroupList(
      @PathVariable int userId)
  {
    return userService.getAllergyFoodGroupList(userId);
  }

  @GetMapping(value = "/allergy/{userId}/ingredient") @Override public Dictionary<Integer, String> getAllergyIngredientList(
      @PathVariable int userId)
  {
    return userService.getAllergyIngredientList(userId);
  }

  @PostMapping(value = "/allergy/{userId}/foodgroup") @Override public boolean SetUserAllergyFoodGroup(
      @PathVariable int userId, @RequestParam int id)
  {
    return userService.SetUserAllergyFoodGroup(userId, id);
  }

  @PostMapping(value = "/allergy/{userId}/ingredient") @Override public boolean SetUserAllergyIngredient(
      @PathVariable int userId, @RequestParam int id)
  {
    return userService.SetUserAllergyIngredient(userId, id);
  }
}
