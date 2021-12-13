package com.dnnr.DNNR_tier3.models.food;

public class Ingredient
{
    private String ingredientName;
    private int amount;
    private int unitId;

    public Ingredient(String ingredientName, int amount, int unitId)
    {
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.unitId = unitId;
    }

    public String getIngredientName()
    {
        return ingredientName;
    }

    public int getAmount()
    {
        return amount;
    }

    public int getUnitId()
    {
        return unitId;
    }
}
