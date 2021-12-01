package com.dnnr.DNNR_tier3.dataAccess.admin;

import com.dnnr.DNNR_tier3.dataAccess.DaoConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;

@Repository public class AdminDao extends DaoConnection implements IAdminDao
{
  public AdminDao()
  {
    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public boolean addIngredient(String ingredientName,
      int foodgroup)
  {
    try (Connection connection = getConnection())
    {
      // Sætter ingrediensen ind
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO Ingredient (name) VALUES ('" + ingredientName + "')");
      statement.execute();

      // Tager id ud fra den indsatte ingrediens
      statement = connection.prepareStatement(
          "SELECT id FROM Ingredient WHERE name = '" + ingredientName + "'");
      ResultSet resultSet = statement.executeQuery();
      resultSet.next();
      int ingredientId = resultSet.getInt("id");

      //Kalder ny metode til at sætte ingrediensen sammen med dens fødevaregrupper
      addIngredientsToFoodgroup(ingredientId, foodgroup);

      //giver true hvis det hele virker
      return true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  public boolean addIngredientsToFoodgroup(int ingredientId,
      int foodgroup)
  {
    try(Connection connection = getConnection())
    {
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO foodgroupingredients(foodgroupid, ingredientid) "
                + "VALUES(" + foodgroup + "," + ingredientId + ")");
          return statement.execute();

    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
      return false;
    }
  }

  @Override public Dictionary<Integer, String> getFoodgroupList()
  {
    Dictionary<Integer, String> foodGroupList = new Hashtable<>();
    try(Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM foodgroup");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next())
      {
        foodGroupList.put(
            resultSet.getInt("id"),
            resultSet.getString("name").toLowerCase());
      }
      return foodGroupList;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public Dictionary<Integer, String> getIngredientList()
  {
    Dictionary<Integer, String> ingredientList = new Hashtable<>();
    try(Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM ingredient");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next())
      {
        ingredientList.put(
            resultSet.getInt("id"),
            resultSet.getString("name").toLowerCase());
      }
      return ingredientList;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

}
