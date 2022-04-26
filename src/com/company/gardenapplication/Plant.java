package com.company.gardenapplication;

public class Plant {
  private double waterAmount;
  private double absorption;

  public Plant(int absorption) {
    waterAmount = 0;
    this.absorption = absorption;
  }

  public boolean needsWater() {
    return waterAmount < 10;
  }

  public double getAbsorption() {
    return absorption;
  }

  public double getWaterAmount() {
    return waterAmount;
  }

  public void watering(double amountOfWater) {
    waterAmount += amountOfWater;
  }

}
