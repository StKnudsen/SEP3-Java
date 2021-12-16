package com.dnnr.DNNR_tier3.models.restaurant;

public class Address
{
  private int id, houseNumber, postalCode;
  private String streetName, city;

  public Address() { }

  public Address(int id, int houseNumber, String streetName, int postalCode,
      String city)
  {
    this.id = id;
    this.houseNumber = houseNumber;
    this.streetName = streetName;
    this.postalCode = postalCode;
    this.city = city;   // Kunne nok hentes fra databasen med postnumre/bynavne :)
  }

  public int getId()
  {
    return id;
  }

  public int getHouseNumber()
  {
    return houseNumber;
  }

  public int getPostalCode()
  {
    return postalCode;
  }

  public String getStreetName()
  {
    return streetName;
  }
}
