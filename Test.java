import Beverages.*;
import Beverages.Beverage.Size;
import Decorators.BeverageDecorator;
import Decorators.Milk;
import Decorators.Sugar;

public class Test {
    public static void main(String[] args) {
        DarkRoast myDarkRoast = new DarkRoast(Size.MEDIUM);
        
        Milk DarkRoastWithMilk = new Milk(myDarkRoast);
        System.out.println(DarkRoastWithMilk.getCalcString());
        System.out.println(DarkRoastWithMilk.cost());
        System.out.println(DarkRoastWithMilk.getBeverage());
        System.out.println(DarkRoastWithMilk.getComponentName());
        System.out.println(DarkRoastWithMilk.getAddedCost());
        System.out.println(DarkRoastWithMilk.getName());
        Sugar DarkRoastWithMilkSugar = new Sugar(DarkRoastWithMilk);
        System.out.println(DarkRoastWithMilkSugar.getCalcString());
        System.out.println(DarkRoastWithMilkSugar.cost());
        System.out.println(DarkRoastWithMilkSugar.getBeverage());
        System.out.println(DarkRoastWithMilkSugar.getComponentName());
        System.out.println(DarkRoastWithMilkSugar.getAddedCost());
        System.out.println(DarkRoastWithMilkSugar.getName());
        BeverageDecorator prevComponent = (BeverageDecorator) DarkRoastWithMilkSugar.getBeverage();
        System.out.println(prevComponent.getComponentName());

        Sugar DarkRoastWithSugar = new Sugar(myDarkRoast);
        System.out.println(DarkRoastWithSugar.getCalcString());
        System.out.println(DarkRoastWithSugar.cost());
        System.out.println(DarkRoastWithSugar.getBeverage());
        System.out.println(DarkRoastWithSugar.getComponentName());
        System.out.println(DarkRoastWithSugar.getAddedCost());
        System.out.println(DarkRoastWithSugar.getName());
        Milk DarkRoastWithSugarMilk = new Milk(DarkRoastWithSugar);
        System.out.println(DarkRoastWithSugarMilk.getCalcString());
        System.out.println(DarkRoastWithSugarMilk.cost());
        System.out.println(DarkRoastWithSugarMilk.getBeverage());
        System.out.println(DarkRoastWithSugarMilk.getComponentName());
        System.out.println(DarkRoastWithSugarMilk.getAddedCost());
        System.out.println(DarkRoastWithSugarMilk.getName());
        BeverageDecorator prevComponent2 = (BeverageDecorator) DarkRoastWithSugarMilk.getBeverage();
        System.out.println(prevComponent2.getComponentName());
    }
}
