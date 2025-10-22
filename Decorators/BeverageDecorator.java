package Decorators;

import Beverages.Beverage;
import java.lang.Math;

public abstract class BeverageDecorator extends Beverage {
    private Beverage beverage;
    private String componentName;
    private double addedCost;

    public BeverageDecorator(Beverage beverage, String componentName, double addedCost) {
        super(beverage.getName() + ", " + componentName, beverage.getBaseCost(), beverage.getSize());
        this.beverage = beverage;
        this.addedCost = Math.round(addedCost * 100.0) / 100.0;
    }

    @Override
    public String getCalcString() {
        // TODO: implement this to make a string that looks like the calculation thing on project description 
        return beverage.getCalcString() + "\n" + "blah blah";
    }

    @Override
    public double cost() {
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

        return beverage.cost() + sizeAdjustedCost;
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
