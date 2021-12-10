package com.dnnr.DNNR_tier3.dataAccess.restaurateur;

import com.dnnr.DNNR_tier3.dataAccess.DaoConnection;
import com.dnnr.DNNR_tier3.models.restaurant.Dish;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurateurDao extends DaoConnection implements IRestaurateurDao {

    public RestaurateurDao() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addDish(Dish dish) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Dish (Name, Description, RestaurantId) VALUES ('"
                            + dish.getName() + ","
                            + dish.getDescription() + ","
                            + dish.getRestaurantId()
                            + "')");
            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("AddDish catch-clause græder");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Dish> getDishList(int restaurantId) {
        List<Dish> dishes = new ArrayList<>();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Dish JOIN restaurant r ON r.id = dish.restaurantid WHERE restaurantid = '"
                            + restaurantId + "'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                dishes.add(new Dish(
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("id"),
                        resultSet.getInt("restaurantId")));
               return dishes;
            }
        }
        catch (SQLException throwables)
        {
            System.out.println("getDishList i catch-clause DAO græder");

            throwables.printStackTrace();
        }
        return null;
    }
}
