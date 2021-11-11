package com.dnnr.DNNR_tier3.models;

public class User
{
    private String username, password;
    private int userId;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public int getUserId()
    {
        return userId;
    }
}
