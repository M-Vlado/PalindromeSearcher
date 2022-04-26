package com.company.gardenapplication;

import com.company.gardenapplication.colorsenums.ColorOfFlowers;

public class Flower extends Plant {
  private ColorOfFlowers color;

  public Flower(ColorOfFlowers color) {
    super(75);
    this.color = color;
  }

  public ColorOfFlowers getColor() {
    return color;
  }

  @Override
  public void watering(double amountOfWater) {
    if (needsWater()) {
      super.watering(amountOfWater * (super.getAbsorption() / 100));
    }
  }

  @Override
  public boolean needsWater() {
    return super.getWaterAmount() < 5;
  }
}
