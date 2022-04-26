package com.company.gardenapplication;

import com.company.gardenapplication.colorsenums.ColorOfFlowers;
import com.company.gardenapplication.colorsenums.ColorsOfTrees;

public class GardenMain {
  public static void main(String[] args) {

    Garden garden = new Garden();

    Plant yellowFlower = new Flower(ColorOfFlowers.YELLOW);
    Plant blueFlower = new Flower(ColorOfFlowers.BLUE);

    Plant purpleTree = new Tree(ColorsOfTrees.PURPLE);
    Plant orangeTree = new Tree(ColorsOfTrees.ORANGE);

    garden.addPlant(yellowFlower);
    garden.addPlant(blueFlower);
    garden.addPlant(purpleTree);
    garden.addPlant(orangeTree);

    garden.gardenSummary();
    garden.wateringGarden(40);
    garden.wateringGarden(70);
  }
}
