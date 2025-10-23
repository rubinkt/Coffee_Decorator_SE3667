package Decorators;

import Beverages.Beverage;

public class Whip extends BeverageDecorator {
    public Whip(Beverage beverage) {
        super(beverage, "Whip", 0.25);
    }
}
