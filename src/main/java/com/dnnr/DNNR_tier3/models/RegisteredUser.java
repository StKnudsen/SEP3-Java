package com.dnnr.DNNR_tier3.models;

public class RegisteredUser extends User
{
    private final String password;
    private int userId;

    public RegisteredUser(String username, String password)
    {
        super(username);
        this.password = password;
    }

    public RegisteredUser(int userId, String username, String password)
    {
        super(username);
        this.userId = userId;
        this.password = password;
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
