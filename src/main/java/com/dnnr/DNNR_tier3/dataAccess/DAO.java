package com.dnnr.DNNR_tier3.dataAccess;

import com.dnnr.DNNR_tier3.models.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DAO extends DaoConnection implements IDAO
{
    @Override public User getUserByUsername(String username)
    {
        try(Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = " + username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            User user = new User(
                    resultSet.getString("Username"),
                    resultSet.getString("Password")
            );
            return user;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override public User setUser(User user)
    {
        return null;
    }

    @Override public List<User> getAllUsers()
    {
        return null;
    }
}
