package com.dnnr.DNNR_tier3.models;

public class CustomPair
{
  private int key;
  private String value;

  public CustomPair(int key, String value)
  {
    this.key = key;
    this.value = value;
  }

  public int getKey()
  {
    return key;
  }

  public String getValue()
  {
    return value;
  }
}
