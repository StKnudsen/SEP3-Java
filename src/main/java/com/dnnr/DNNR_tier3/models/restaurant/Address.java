package com.dnnr.DNNR_tier3.models.restaurant;

public class Address
{
    private int id, houseNumber, postalCode;
    private String streetName, city;


    public Address(int id, int houseNumber, String streetName, int postalCode, String city)
    {
        this.id = id;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Address()
    {
    }

    public int getId()
    {
        return id;
    }

    public int getHouseNumber()
    {
        return houseNumber;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public int getPostalCode()
    {
        return postalCode;
    }
}
