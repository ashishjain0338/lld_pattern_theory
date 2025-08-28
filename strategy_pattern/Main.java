package strategy_pattern;

import strategy_pattern.context.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World");
        // Let's create some nav objects
        Navigation nav1 = new WalkNavigation("walk-obj1");
        Navigation nav2 = new CarNavigation("car-obj1");
        Navigation nav3 = new BikeNavigation("bike-obj1");

        nav1.navigate(23);
        nav2.navigate(45);
        nav3.navigate(67);
        nav3.changeRouteStrategy("scenic");
        nav3.navigate(1);

    }
}
