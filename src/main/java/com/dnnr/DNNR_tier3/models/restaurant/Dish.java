package com.dnnr.DNNR_tier3.models.restaurant;

public class Dish {
    private String name, description;
    private int id, restaurantId;

    public Dish() {}

    public Dish(String name, String description, int id,int restaurantId) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }
}
