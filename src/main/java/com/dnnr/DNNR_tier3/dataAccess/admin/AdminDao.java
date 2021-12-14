package com.dnnr.DNNR_tier3.dataAccess.admin;

import com.dnnr.DNNR_tier3.dataAccess.DaoConnection;
import com.dnnr.DNNR_tier3.models.restaurant.Address;
import com.dnnr.DNNR_tier3.models.restaurant.Restaurant;
import com.dnnr.DNNR_tier3.models.food.Recipe;
import com.dnnr.DNNR_tier3.models.food.Ingredient;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

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

    @Override public boolean addIngredient(String ingredientName, int foodGroup)
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
            addIngredientToFoodGroup(ingredientId, foodGroup);

            //giver true hvis det hele virker
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("AddIngredient catch-clause græder");
            e.printStackTrace();
        }
        return false;
    }

    @Override public boolean addFoodGroup(String foodGroupName)
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO foodgroup(name) VALUES('" + foodGroupName + "')"
            );
            statement.execute();
            return true;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override public boolean addIngredientToFoodGroup(int ingredientId, int foodGroup)
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO foodgroupingredients(foodgroupid, ingredientid) "
                            + "VALUES(" + foodGroup + "," + ingredientId + ")");
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
                    "INSERT INTO recipe (name) VALUES ('" + recipe.getName()
                            + "')");
            statement.execute();

            // Tager id ud fra den indsatte recipe
            statement = connection.prepareStatement(
                    "SELECT id FROM recipe WHERE name = '" + recipe.getName()
                            + "'");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int recipeId = resultSet.getInt("id");

            //Kalder ny metode til at sætte opskriften sammen med dens ingredienser

            addIngredientsToRecipe(recipeId, recipe.getRecipeIngredient());

            //giver true hvis det hele virker
            return true;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override public boolean addRestaurant(Restaurant restaurant)
    {
        try (Connection connection = getConnection())
        {
            System.out.println("AdminDao i addRestaurant");
            // Sætter adresse ind
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Address(streetname, housenumber, postalcode) VALUES ('"
                            + restaurant.getAddress().getStreetName() + "', '"
                            + restaurant.getAddress().getHouseNumber() + "', '"
                            + restaurant.getAddress().getPostalCode()
                            + "')");
            statement.execute();

            // Trækker id ud fra den indsatte adresse
            statement = connection.prepareStatement(
                    "SELECT id FROM address WHERE streetname = '"
                            + restaurant.getAddress().getStreetName() + "'");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int addressId = resultSet.getInt("id");

            // Tilføjer restaurant med addresseId i databasen
            statement = connection.prepareStatement(
                    "INSERT INTO Restaurant(cvr, name, ownerid, theme, addressid, phonenumber) VALUES ('"
                            + restaurant.getCvr() + "', '"
                            + restaurant.getName() + "', '"
                            + restaurant.getOwnerId() + "', '"
                            + restaurant.getTheme() + "', '"
                            + addressId + "', '"
                            + restaurant.getPhoneNumber() + "')");
            return statement.execute();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return false;
    }

    private void addIngredientsToRecipe(int recipeId,
            List<Ingredient> recipeIngredient)
    {
        try (Connection connection = getConnection())
        {
            for (Ingredient ingredient : recipeIngredient)
            {
                Ingredient temp = new Ingredient(
                        ingredient.getIngredientName(), ingredient.getAmount(),
                        ingredient.getUnitId());

                String tempIngredientName = temp.getIngredientName();
                String ingredientName =
                        tempIngredientName.substring(0, 1).toUpperCase()
                                + tempIngredientName.substring(1).toLowerCase();
                System.out.println("IngredientName: " + ingredientName);
                int amount = temp.getAmount();
                int unit = temp.getUnitId();

                PreparedStatement statement = connection.prepareStatement(
                        "SELECT id FROM ingredient WHERE name = '"
                                + ingredientName + "'");
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                int ingredientId = resultSet.getInt("id");

                System.out.println("amount: " + amount);
                System.out.println("unit: " + unit);

                statement = connection.prepareStatement(
                        "INSERT INTO recipeingredients(recipeid, ingredientid, amount, unitid) "
                                + "VALUES(" + recipeId + "," + ingredientId
                                + "," + amount + "," + unit + ")");
                statement.execute();

            }
        }
        catch (SQLException throwables)
        {
            System.out.println("AddIngredientsToRecipe catch-clause græder");

            throwables.printStackTrace();
        }
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

    @Override
    public Dictionary<Integer, String> getUsersAndRestaurateurListAsync() {
        Dictionary<Integer, String> userList = new Hashtable<>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE role = 'Restaurateur' or role = 'User'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                userList.put(resultSet.getInt("id"),
                        resultSet.getString("username").toLowerCase());
            }
            return userList;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public List<Restaurant> getRestaurantList()
    {
        try (Connection connection = getConnection())
        {
            List<Restaurant> restaurantList = new LinkedList<>();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Restaurant JOIN address a ON a.id = restaurant.addressid");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Restaurant restaurant = new Restaurant(resultSet.getInt("id"),
                        resultSet.getInt("cvr"), resultSet.getString("name"),
                        resultSet.getInt("ownerid"),
                        resultSet.getString("theme"),
                        getAddressById(resultSet.getInt("addressId")),
                        resultSet.getString("phonenumber"));
                restaurantList.add(restaurant);
            }
            return restaurantList;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public List<Address> getAddressList()
    {
        List<Address> addressList = new LinkedList<>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM address " +
                            "JOIN city c ON c.postalcode = address.postalcode");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Address address = new Address(
                        resultSet.getInt("id"),
                        resultSet.getInt("housenumber"),
                        resultSet.getString("streetname"),
                        resultSet.getInt("postalcode"),
                        resultSet.getString("cityName")
                );
                addressList.add(address);
            }
            return addressList;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public Address getAddressById(int addressId)
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Address JOIN city c ON c.postalcode = address.postalcode WHERE id = '"
                            + addressId + "'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                return new Address(resultSet.getInt("id"),
                        resultSet.getInt("housenumber"),
                        resultSet.getString("streetname"),
                        resultSet.getInt("postalcode"),
                        resultSet.getString("cityName"));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }
}
