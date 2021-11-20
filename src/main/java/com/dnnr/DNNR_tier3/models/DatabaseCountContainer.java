package com.dnnr.DNNR_tier3.models;

public class DatabaseCountContainer
{
  private final int animalCount;
  private final int colourCount;

  public DatabaseCountContainer(int animalCount, int colourCount)
  {
    this.animalCount = animalCount;
    this.colourCount = colourCount;
  }

  public int getAnimalCount()
  {
    return animalCount;
  }

  public int getColourCount()
  {
    return colourCount;
  }
}
