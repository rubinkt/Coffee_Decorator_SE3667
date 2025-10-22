package Decorators;

import Beverages.Beverage;

public class Milk extends BeverageDecorator {
    public Milk(Beverage beverage) {
        super(beverage, "Milk", 0.20);
    }
}
