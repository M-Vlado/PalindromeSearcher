package com.company.gardenapplication;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  private List<Plant> plants = new ArrayList<>();

  public void addPlant(Plant plant) {
    plants.add(plant);
  }

  public int howManyNeedsWater() {
    int needsWater = 0;
    for (Plant plant : plants) {
      if (plant.needsWater()) {
        needsWater++;
      }
    }
    return needsWater;
  }

  public void wateringGarden(int availableAmountOfWater) {
    System.out.println("Watering with " + availableAmountOfWater);
    double amountWaterForEachPlant = availableAmountOfWater / howManyNeedsWater();

    for (Plant plant : plants) {
      if (plant.needsWater()) {
        plant.watering(amountWaterForEachPlant);
      }
    }
    gardenSummary();

  }

  public void gardenSummary() {
    for (Plant plant : plants) {
      String needsWater = "The ";
      if (plant.needsWater()) {
        if (plant instanceof Flower) {
          needsWater += ((Flower) plant).getColor().getFlowerColor() + " Flower needs water";
        } else {
          needsWater += ((Tree) plant).getColor().getTreeColor() + " Tree needs water";
        }
      } else {
        if (plant instanceof Flower) {
          needsWater +=
              ((Flower) plant).getColor().getFlowerColor() + " Flower doesn't needs water";
        } else {
          needsWater += ((Tree) plant).getColor().getTreeColor() + " Tree doesn't needs water";
        }
      }

      System.out.println(needsWater);
    }
    System.out.println();
  }


}
