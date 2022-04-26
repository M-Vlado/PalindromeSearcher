package com.company.gardenapplication.colorsenums;

public enum ColorsOfTrees {
  PURPLE("purple"), ORANGE("orange");

  private String treeColor;

  ColorsOfTrees(String treeColor) {
    this.treeColor = treeColor;
  }

  public String getTreeColor() {
    return treeColor;
  }
}
