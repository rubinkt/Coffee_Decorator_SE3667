import Beverages.*;

public class Test {
    public static void main(String[] args) {
        DarkRoast myDarkRoast = new DarkRoast(Beverage.Size.SMALL);
        System.out.println(myDarkRoast.getDescription());
        System.out.println(myDarkRoast.cost());

        DarkRoast myDarkRoast2 = new DarkRoast(Beverage.Size.MEDIUM);
        System.out.println(myDarkRoast2.getDescription());
        System.out.println(myDarkRoast2.cost());

        DarkRoast myDarkRoast3 = new DarkRoast(Beverage.Size.LARGE);
        System.out.println(myDarkRoast3.getDescription());
        System.out.println(myDarkRoast3.cost());
    }
}
