package com.dnnr.DNNR_tier3.dataAccess.user;

import com.dnnr.DNNR_tier3.dataAccess.DaoConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Dictionary;
import java.util.Hashtable;

@Repository
public class UserDao extends DaoConnection implements IUserDao
{
  @Override public Dictionary<Integer, String> getAllergyFoodGroupList(int userId)
  {
    if (userId == 0)
    {
      System.out.println("Get allergy food group for user failed...");
    }

    Dictionary<Integer, String> allergyList = new Hashtable<>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM dnnr.foodgroupallergy "
              + "JOIN dnnr.foodgroup f on foodgroupallergy.foodgroupid = f.id WHERE userid = "
              + userId
      );
      ResultSet result = statement.executeQuery();
      while (result.next())
      {
        allergyList.put(
            result.getInt("foodgroupid"),
            result.getString("name")
        );
      }

      return allergyList;
    }
    catch (SQLException e)
    {
      System.out.println("SQL exception for get allergy food group: " + e.getMessage());
    }

    return null;
  }

  @Override public Dictionary<Integer, String> getAllergyIngredientList(int userId)
  {
    if (userId == 0)
    {
      System.out.println("Get allergy ingredient for user failed...");
    }

    Dictionary<Integer, String> allergyList = new Hashtable<>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM dnnr.ingredientallergy "
              + "JOIN dnnr.ingredient i on ingredientallergy.ingredientid = i.id WHERE userid = "
              + userId
      );
      ResultSet result = statement.executeQuery();
      while (result.next())
      {
        allergyList.put(
            result.getInt("ingredientid"),
            result.getString("name")
        );
      }

      return allergyList;
    }
    catch (SQLException e)
    {
      System.out.println("SQL exception for get allergy ingredient: " + e.getMessage());
    }

    return null;
  }

  @Override public boolean setUserAllergyFoodGroup(int userId, int foodGroupId)
  {
    if (userId == 0)
    {
      System.out.println("Set allergy food group for user failed...");
    }
     try (Connection connection = getConnection())
     {
        PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO dnnr.foodgroupallergy (userid, foodgroupid) VALUES (" + userId + ", " + foodGroupId +");"
        );

        return statement.execute();
     }
     catch (SQLException e)
     {
       System.out.println("SQL exception for set allergy food group: " + e.getMessage());
     }

    return false;
  }

  @Override public boolean setUserAllergyIngredient(int userId, int ingredient)
  {
    if (userId == 0)
    {
      System.out.println("Set allergy ingredient for user failed...");
    }
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO dnnr.ingredientallergy (userid, ingredientid) VALUES (" + userId + ", " + ingredient +");"
      );

      return statement.execute();
    }
    catch (SQLException e)
    {
      System.out.println("SQL exception for set allergy ingredient: " + e.getMessage());
    }

    return false;
  }
}
