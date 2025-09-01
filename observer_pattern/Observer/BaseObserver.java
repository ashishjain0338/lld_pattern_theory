package observer_pattern.Observer;

import java.util.Map;
import utils.utils;

abstract public class BaseObserver implements Observer{

    String id = null;
    String observerType = null;

    public BaseObserver(String id, String observerType){
        this.id = id;
        this.observerType = observerType;
    }

    @Override
    public void updateContext(Map<String, Double> data){
        System.out.println("Recieved Context : ");
        utils.printMap(data);   
    }

    public String toString(){
        return String.format("Observer-id : %s, Observer-Type : %s", this.id, this.observerType);
    }

    public String getId(){
        return this.id;
    }
}
