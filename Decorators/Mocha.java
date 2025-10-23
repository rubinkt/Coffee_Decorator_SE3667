package Decorators;

import Beverages.Beverage;

public class Mocha extends BeverageDecorator {
    public Mocha(Beverage beverage) {
        super(beverage, "Mocha", 0.30);
    }
}