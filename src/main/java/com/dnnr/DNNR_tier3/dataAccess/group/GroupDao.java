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

@Repository public class GroupDao extends DaoConnection implements IGroupDao
{
  @Override public List<CustomPair> getShuffledRecipes(String ingredients,
      String foodGroups)
  {
    List<CustomPair> recipes = new ArrayList<>();
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM recipe WHERE id not in "
              + " (SELECT id FROM recipe JOIN recipeingredients r on recipe.id = r.recipeid"
              + "WHERE ingredientid in (" + ingredients + "))"
              + "AND id not in (SELECT id FROM recipe "
              + "JOIN recipeingredients r on recipe.id = r.recipeid"
              + "JOIN foodgroupingredients f on r.ingredientid = f.ingredientid"
              + "WHERE foodgroupid in(" + foodGroups + "))"
              + "ORDER BY RANDOM(), id, name LIMIT (250 )");
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        CustomPair pair = new CustomPair(resultSet.getInt("id"),
            resultSet.getString("Name"));
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
              + "SELECT COUNT(*) FROM Restaurant" + ")");
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        CustomPair pair = new CustomPair(resultSet.getInt("id"),
            resultSet.getString("Name"));
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
