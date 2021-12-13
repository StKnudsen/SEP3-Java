package com.dnnr.DNNR_tier3.dataAccess.authentication;

import com.dnnr.DNNR_tier3.dataAccess.DaoConnection;
import com.dnnr.DNNR_tier3.models.user.RegisteredUser;
import com.dnnr.DNNR_tier3.models.user.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository public class AuthenticationDao extends DaoConnection implements IAuthenticationDao
{
    public AuthenticationDao()
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
                    resultSet.getString("Password"), resultSet.getString("Role"));
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
                    "INSERT INTO Users(role, username, password) VALUES ('" + registeredUser.getRole() + "', '" + registeredUser.getUsername()
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

    @Override public List<User> getAllUsers()
    {
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Users");
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();

            while (resultSet.next())
            {
                User user = new RegisteredUser(
                    resultSet.getInt("id"), resultSet.getString("username"),
                    resultSet.getString("password"), resultSet.getString("role")
                );

                users.add(user);
            }

            return users;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }
}
