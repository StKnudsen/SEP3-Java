package com.dnnr.DNNR_tier3.models;

public class RecipeIngredient
{
    private String IngredientName;
    private int Amount;
    private int UnitId;

    public RecipeIngredient(String ingredientName, int amount, int unitId)
    {
        IngredientName = ingredientName;
        Amount = amount;
        UnitId = unitId;
    }

    public String getIngredientName()
    {
        return IngredientName;
    }

    public int getAmount()
    {
        return Amount;
    }

    public int getUnitId()
    {
        return UnitId;
    }
}
