package Decorators;

import Beverages.Beverage;

public class Caramel extends BeverageDecorator {
    public Caramel(Beverage beverage) {
        super(beverage, "Caramel", 0.30);
    }
}