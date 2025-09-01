package observer_pattern.Observer;

import java.util.Map;
import utils.utils;

abstract public class BaseObserver implements Observer{

    String id = null;

    public BaseObserver(String id){
        this.id = id;
    }

    @Override
    public void updateContext(Map<String, Double> data){
        System.out.println("Recieved Context : ");
        utils.printMap(data);   
    }
}
