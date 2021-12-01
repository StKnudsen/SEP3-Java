package com.dnnr.DNNR_tier3.dataAccess;

import com.dnnr.DNNR_tier3.models.RegisteredUser;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.TreeMap;

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

    @Override public RegisteredUser getUserByUsername(String username)
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Users WHERE username = '" + username + "'");
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next())
            {
                return new RegisteredUser(null, null);
            }
            return new RegisteredUser(resultSet.getInt("id"), resultSet.getString("Username"),
                    resultSet.getString("Password"));
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public Boolean setUser(RegisteredUser registeredUser)
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Users(username, password) VALUES ('" + registeredUser.getUsername()
                            + "', '" + registeredUser.getPassword() + "')");
            return statement.execute();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override public int getAnimalCount()
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT count(name) FROM animals"
            );
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("count");
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override public int getColourCount()
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT count(name) FROM colours"
            );
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("count");
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override public String getAnimal(int id)
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT name FROM animals WHERE id = " + id
            );

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getString("name");
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public String getColour(int id)
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT name FROM colours WHERE id = " + id
            );

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getString("name");
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
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
