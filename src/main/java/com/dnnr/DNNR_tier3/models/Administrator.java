package com.dnnr.DNNR_tier3.models;

public class Administrator extends User
{
  private final String password;

  public Administrator(String name, String password)
  {
    super(name);
    this.password = password;
  }


}
