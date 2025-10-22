package Beverages;

import java.lang.Math;

public abstract class Beverage {
  public static enum Size {SMALL, MEDIUM, LARGE}

  private String name;
  private double baseCost;
  private Size size;

  public Beverage(String name, double baseCost, Size size) {
    this.name = name;
    this.baseCost = Math.round(baseCost * 100.0) / 100.0;
    this.size = size;
  }

  public double cost() {
    double totalCost = baseCost;
    switch (size) {
      case SMALL:
        // No need for a x1 multiplier
        break;
      case MEDIUM:
        totalCost *= 1.2;
        break;
      case LARGE:
        totalCost *= 1.4;
        break;
    }
    totalCost = Math.round(totalCost * 100.0) / 100.0;

    return totalCost;
  }

  public String getCalcString() {
    // TODO: implement this to make a string that looks like the calculation thing on project description 
    return "placeholder base beverage text";
  }

  public String getName() {
    return name;
  }

  public double getBaseCost() {
    return baseCost;
  }

  public Size getSize() {
    return size;
  }
}