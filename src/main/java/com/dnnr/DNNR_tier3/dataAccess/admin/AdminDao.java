package com.dnnr.DNNR_tier3.dataAccess.admin;

import com.dnnr.DNNR_tier3.dataAccess.DaoConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminDao extends DaoConnection implements IAdminDao
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
          "INSERT INTO INGREDIENT (name) VALUES ('" + ingredientName + "')");
      statement.execute();

      // Tager id ud fra den indsatte ingrediens
      int ingredientId = connection.prepareStatement(
          "SELECT id FROM ingredient WHERE name = '" + ingredientName + "'")
          .executeQuery().getInt("id");
      //Kalder ny metode til at sætte ingrediensen sammen med dens fødevaregrupper
      addIngredientsToFoodgroups(ingredientId, foodgroup);

      //giver true hvis det hele virker
      return true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  public boolean addIngredientsToFoodgroups(int ingredientId,
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
}
