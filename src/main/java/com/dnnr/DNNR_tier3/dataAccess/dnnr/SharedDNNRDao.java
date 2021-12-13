package com.dnnr.DNNR_tier3.dataAccess.dnnr;

import com.dnnr.DNNR_tier3.dataAccess.DaoConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;

@Repository
public class SharedDNNRDao extends DaoConnection implements ISharedDNNRDao
{
  @Override public Dictionary<Integer, String> getFoodgroupList()
  {
    Dictionary<Integer, String> foodGroupList = new Hashtable<>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM foodgroup");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next())
      {
        foodGroupList.put(resultSet.getInt("id"),
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
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM ingredient");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next())
      {
        ingredientList.put(resultSet.getInt("id"),
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
