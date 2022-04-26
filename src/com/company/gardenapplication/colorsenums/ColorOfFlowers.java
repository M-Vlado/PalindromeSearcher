package com.company.gardenapplication.colorsenums;

public enum ColorOfFlowers {
  YELLOW("yellow"), BLUE("blue");

  private String flowerColor;

  ColorOfFlowers(String flowerColor) {
    this.flowerColor = flowerColor;
  }

  public String getFlowerColor() {
    return flowerColor;
  }
}
