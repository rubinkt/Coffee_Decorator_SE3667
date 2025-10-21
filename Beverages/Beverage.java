package Beverages;

import java.lang.Math;

public abstract class Beverage {
  public static enum Size {SMALL, MEDIUM, LARGE}

  private String description;
  private double baseCost;
  private Size size;

  public Beverage(String description, double baseCost, Size size) {
    this.description = description;
    this.baseCost = baseCost;
    this.size = size;
  }
  
  public String getDescription() {
    return description;
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
}