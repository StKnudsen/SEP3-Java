package com.dnnr.DNNR_tier3.dataAccess.group;

import com.dnnr.DNNR_tier3.dataAccess.DaoConnection;
import com.dnnr.DNNR_tier3.models.CustomPair;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupDao extends DaoConnection implements IGroupDao
{
  @Override public List<CustomPair> getShuffledRecipes()
  {
    List<CustomPair> recipes = new ArrayList<>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM recipe ORDER BY RANDOM() LIMIT ("
              + "SELECT COUNT(*) FROM recipe"
              + ")"
      );
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        CustomPair pair = new CustomPair(
            resultSet.getInt("id"), resultSet.getString("Name")
        );
        recipes.add(pair);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return recipes;
  }

  @Override public List<CustomPair> getShuffledRestaurants()
  {
    List<CustomPair> restaurants = new ArrayList<>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Restaurant ORDER BY RANDOM() LIMIT ("
              + "SELECT COUNT(*) FROM Restaurant"
              + ")"
      );
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        CustomPair pair = new CustomPair(
            resultSet.getInt("id"), resultSet.getString("Name")
        );
        restaurants.add(pair);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return restaurants;
  }
}
