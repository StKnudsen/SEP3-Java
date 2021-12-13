package com.dnnr.DNNR_tier3.models.restaurant;

public class Restaurant
{
    private int id, cvr;
    private String name, theme, phoneNumber;
    private Address address;

    public Restaurant()
    {
    }

    public Restaurant(int id, int cvr, String name, String theme, Address address,
            String phoneNumber)
    {
        this.id = id;
        this.cvr = cvr;
        this.address = address;
        this.name = name;
        this.theme = theme;
        this.phoneNumber = phoneNumber;
    }

    public int getId()
    {
        return id;
    }

    public int getCvr()
    {
        return cvr;
    }

    public String getName()
    {
        return name;
    }

    public String getTheme()
    {
        return theme;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public Address getAddress()
    {
        return address;
    }
}
