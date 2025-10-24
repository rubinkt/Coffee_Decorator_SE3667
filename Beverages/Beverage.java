package Beverages;

import java.lang.Math;

/** Abstract class containing common behaviors among beverages. */
public abstract class Beverage {
  /** Lists the sizes tht a beverage can have */
  public static enum Size {SMALL, MEDIUM, LARGE}

  /** Text that shows the human-readable name of the beverage */
  private String name;
  /** Cost of the beverage before size is taken into account */
  private double baseCost;
  private Size size;

  public Beverage(String name, double baseCost, Size size) {
    this.name = name;
    this.baseCost = Math.round(baseCost * 100.0) / 100.0;
    this.size = size;
  }

  /** Calculates the cost of the beverage.
   * 
   * @return the cost of the beverage, adjusted for size, rounded to two decimal points.
   */
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

  /** Returns a representation of the cost for calculation.
   * 
   * @return A string representing the calculation of the cost of the beverage, fixed to 41 characters long.
   */
  public String getCalcString() {
    double multiplier = 1.0;
    switch (size) {
      case SMALL:
        // It's already 1.0
        break;
      case MEDIUM:
        multiplier = 1.2;
        break;
      case LARGE:
        multiplier = 1.4;
        break;
    }
    String line = String.format("%1$-16s $%2$-6.2f X %3$-6.1f = $%4$-7.2f", name, baseCost, multiplier, cost());
    return line;
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