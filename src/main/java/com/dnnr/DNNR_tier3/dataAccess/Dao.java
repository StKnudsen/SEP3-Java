package com.dnnr.DNNR_tier3.dataAccess;

import com.dnnr.DNNR_tier3.models.User;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository public class Dao extends DaoConnection implements IDao
{
    public Dao()
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

    @Override public User getUserByUsername(String username)
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Users WHERE username = '" + username + "'");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            User user = new User(resultSet.getInt("id"), resultSet.getString("Username"),
                    resultSet.getString("Password"));
            return user;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public Boolean setUser(User newUser)
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Users(username, password) VALUES ('" + newUser.getUsername()
                            + "', '" + newUser.getPassword() + "')");
            return statement.execute();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return false;
    }

   /* @Override public List<User> getAllUsers()
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Users");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            List<User> user = new User(resultSet.getString("Username"),
                    resultSet.getString("Password"));
            return user;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }*/
}
