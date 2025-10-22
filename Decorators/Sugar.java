package Decorators;

import Beverages.Beverage;

public class Sugar extends BeverageDecorator {
    public Sugar(Beverage beverage) {
        super(beverage, "Sugar", 0.10);
    }
}
