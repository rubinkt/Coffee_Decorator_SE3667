package Decorators;

import Beverages.Beverage;

public class Vanilla extends BeverageDecorator {
    public Vanilla(Beverage beverage) {
        super(beverage, "Vanilla", 0.30);
    }
}
