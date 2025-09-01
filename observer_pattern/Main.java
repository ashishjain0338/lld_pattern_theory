package observer_pattern;

import observer_pattern.Observer.Observer;

import java.util.TreeMap;

import observer_pattern.Observables.Observable;
import observer_pattern.Observables.RainfallPredictorService;
import observer_pattern.Observer.MobileObserver;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello World");
        Observer myobv = new MobileObserver("b");
        Observable rain = new RainfallPredictorService();
        rain.addObserver(myobv);
        rain.updateContext(89.0);
    }
    
}
