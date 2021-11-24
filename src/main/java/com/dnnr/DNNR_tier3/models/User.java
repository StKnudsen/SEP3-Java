package com.dnnr.DNNR_tier3.models;

public abstract class User
{
  private final String username;

  public User(String name)
  {
    this.username = name;
  }

  public String getUsername()
  {
    return username;
  }
}
