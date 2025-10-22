import Beverages.*;
import Beverages.Beverage.Size;
import Decorators.Milk;
import Decorators.Sugar;

public class Test {
    public static void main(String[] args) {
        DarkRoast myDarkRoast = new DarkRoast(Size.SMALL);
        System.out.println(myDarkRoast.getCalcString());
        
        Milk DarkRoastWithMilk = new Milk(myDarkRoast);
        System.out.println(DarkRoastWithMilk.getCalcString());
        Sugar DarkRoastWithMilkSugar = new Sugar(DarkRoastWithMilk);
        System.out.println(DarkRoastWithMilkSugar.getCalcString());

        Sugar DarkRoastWithSugar = new Sugar(myDarkRoast);
        System.out.println(DarkRoastWithSugar.getCalcString());
        Milk DarkRoastWithSugarMilk = new Milk(DarkRoastWithSugar);
        System.out.println(DarkRoastWithSugarMilk.getCalcString());
    }
}
