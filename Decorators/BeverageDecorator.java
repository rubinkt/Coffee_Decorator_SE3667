package Decorators;

import Beverages.Beverage;

import java.lang.Math;

/** Implementation of a decorator for beverages to add condiments. */
public abstract class BeverageDecorator extends Beverage {
    /** The beverage being decorated */
    private Beverage beverage;
    /** The human-readable name of the decoration */
    private String componentName;
    private double addedCost;

    public BeverageDecorator(Beverage beverage, String componentName, double addedCost) {
        super(beverage.getName() + ", " + componentName, beverage.getBaseCost(), beverage.getSize());
        this.beverage = beverage;
        this.componentName = componentName;
        this.addedCost = Math.round(addedCost * 100.0) / 100.0;
    }

    @Override
    public String getCalcString() {
        double multiplier = 1.0;
        switch (beverage.getSize()) {
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
        String line = String.format("%1$-16s $%2$-6.2f X %3$-6.1f = $%4$-7.2f", componentName, addedCost, multiplier, componentCost());
        return beverage.getCalcString() + "\n" + line;
    }

    /** Returns the cost of the individual condiment.
     * 
     * @return The cost of the condiment, rounded to 2 decimal places.
     */
    public double componentCost() {
        double sizeAdjustedCost = addedCost;
        switch (beverage.getSize()) {
            case SMALL:
                // No need for a x1 multiplier
                break;
            case MEDIUM:
                sizeAdjustedCost *= 1.2;
                break;
            case LARGE:
                sizeAdjustedCost *= 1.4;
                break;
        }
        sizeAdjustedCost = Math.round(sizeAdjustedCost * 100.0) / 100.0;
        return sizeAdjustedCost;
    }

    @Override
    public double cost() {
        double sizeAdjustedCost = componentCost();
        return Math.round((beverage.cost() + sizeAdjustedCost) * 100.0) / 100.0;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public String getComponentName() {
        return componentName;
    }

    public double getAddedCost() {
        return addedCost;
    }
}
