package observer_pattern.Observables;
import java.util.*;

import observer_pattern.Observer.Observer;

public class RainfallPredictorService implements Observable{
    ArrayList<Observer> observerList = new ArrayList<>();
    
    public void addObserver(Observer obv){
        if(observerList.contains(obv)){
            // Already Exists
            return;
        }
        observerList.add(obv);
    }

    public void removeObserver(Observer obv){
        observerList.remove(obv);
    }

    public void updateContext(Double newRainfall){
        Map<String, Double> mp = new TreeMap<>();
        mp.put("Rainfall", newRainfall);

        for(int i = 0;i < this.observerList.size(); i++){
            Observer obv = observerList.get(i);
            obv.updateContext(mp);
        }
    }

    public String toString(){
        String out = "Rainfall Subscriber's are : ";
        for(int i = 0;i < this.observerList.size(); i++){
            Observer cur = this.observerList.get(i);
            out += (cur.getId() + ", ");
        }
        return out;
    }
}
