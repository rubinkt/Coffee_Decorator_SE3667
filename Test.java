import Beverages.*;

public class Test {
    public static void main(String[] args) {
        DarkRoast myDarkRoast = new DarkRoast(Beverage.Size.SMALL);
        System.out.println(myDarkRoast.getName());
        System.out.println(myDarkRoast.getBaseCost());
        System.out.println(myDarkRoast.getSize());
        System.out.println(myDarkRoast.getCalcString());
        System.out.println(myDarkRoast.cost());

        DarkRoast myDarkRoast2 = new DarkRoast(Beverage.Size.MEDIUM);
        System.out.println(myDarkRoast2.getName());
        System.out.println(myDarkRoast2.getBaseCost());
        System.out.println(myDarkRoast2.getSize());
        System.out.println(myDarkRoast2.getCalcString());
        System.out.println(myDarkRoast2.cost());

        DarkRoast myDarkRoast3 = new DarkRoast(Beverage.Size.LARGE);
        System.out.println(myDarkRoast3.getName());
        System.out.println(myDarkRoast3.getBaseCost());
        System.out.println(myDarkRoast3.getSize());
        System.out.println(myDarkRoast3.getCalcString());
        System.out.println(myDarkRoast3.cost());
    }
}
