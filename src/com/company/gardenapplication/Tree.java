package com.company.gardenapplication;

import com.company.gardenapplication.colorsenums.ColorsOfTrees;

public class Tree extends Plant {
  private ColorsOfTrees color;

  public Tree(ColorsOfTrees color) {
    super(40);
    this.color = color;
  }

  public ColorsOfTrees getColor() {
    return color;
  }

  @Override
  public boolean needsWater() {
    return super.getWaterAmount() < 10;
  }

  @Override
  public void watering(double amountOfWater) {
    if (needsWater()) {
      super.watering(amountOfWater * (super.getAbsorption() / 100));
    }
  }
}
