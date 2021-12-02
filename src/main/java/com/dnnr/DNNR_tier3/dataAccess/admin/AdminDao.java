package com.dnnr.DNNR_tier3.dataAccess.admin;

import com.dnnr.DNNR_tier3.dataAccess.DaoConnection;
import com.dnnr.DNNR_tier3.models.Recipe;
import com.dnnr.DNNR_tier3.models.RecipeIngredient;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
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

    @Override public boolean addIngredient(String ingredientName, int foodgroup)
    {
        try (Connection connection = getConnection())
        {
            // Sætter ingrediensen ind
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Ingredient (name) VALUES ('" + ingredientName
                            + "')");
            statement.execute();

            // Tager id ud fra den indsatte ingrediens
            statement = connection.prepareStatement(
                    "SELECT id FROM Ingredient WHERE name = '" + ingredientName
                            + "'");
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

    public boolean addIngredientsToFoodgroup(int ingredientId, int foodgroup)
    {
        try (Connection connection = getConnection())
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

    @Override public boolean addRecipe(Recipe recipe)
    {
        try (Connection connection = getConnection())
        {
            //Sætter recipe ind
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO recipe (name) VALUES ('" + recipe.Name + "')");
            statement.execute();

            // Tager id ud fra den indsatte recipe
            statement = connection.prepareStatement(
                    "SELECT id FROM recipe WHERE name = '" + recipe.Name + "'");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int recipeId = resultSet.getInt("id");

            //Kalder ny metode til at sætte opskriften sammen med dens ingredienser
            addIngredientsToRecipe(recipeId, recipe.RecipeIngredient);

            //giver true hvis det hele virker
            return true;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return false;
        }
    }

    private boolean addIngredientsToRecipe(int recipeId,
            List<RecipeIngredient> recipeIngredient)
    {
        for (RecipeIngredient ingredient : recipeIngredient)
        {
            try (Connection connection = getConnection())
            {
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO recipeingredients(recipeid, ingredientid, amount, unitid) "
                                + "VALUES(" +
                                recipeId + "," +
                                ingredient + "," +
                                recipeIngredient.get(ingredient.Amount) + "," +
                                recipeIngredient.get(ingredient.UnitId) + ")");
                System.out.println(recipeId);
                System.out.println(ingredient);
                System.out.println(ingredient.Amount);
                System.out.println(ingredient.UnitId);
                return statement.execute();
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
                return false;
            }
        }
        return false;
    }

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

    @Override public Dictionary<Integer, String> getUnitList()
    {
        Dictionary<Integer, String> unitList = new Hashtable<>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM unit");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                unitList.put(resultSet.getInt("id"),
                        resultSet.getString("name").toLowerCase());
            }
            return unitList;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public Dictionary<Integer, String> getRecipeList()
    {
        Dictionary<Integer, String> recipeList = new Hashtable<>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM recipe");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                recipeList.put(resultSet.getInt("id"),
                        resultSet.getString("name").toLowerCase());
            }
            return recipeList;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

}
