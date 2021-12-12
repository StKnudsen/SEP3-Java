package com.dnnr.DNNR_tier3.models.user;

public abstract class User
{
  private final String username;
  private String role;

  public User(String name)
  {
    this.username = name;
  }

  public User(String name, String role)
  {
    this.username = name;
    this.role = role;
  }

  public String getUsername()
  {
    return username;
  }

  public String getRole()
  {
    return role;
  }
}
