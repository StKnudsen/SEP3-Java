package com.dnnr.DNNR_tier3.dataAccess;

import com.dnnr.DNNR_tier3.util.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnection
{
    protected Connection getConnection() throws SQLException
    {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres?currentSchema=dnnr",
                util.USER, util.PASSWORD
        );
        return connection;
    }
}
