package observer_pattern.Observables;
import java.util.*;

import observer_pattern.Observer.Observer;

public class TemperatureService implements Observable{
    ArrayList<Observer> observerList = new ArrayList<>();
    
    public void addObserver(Observer obv){
        observerList.add(obv);
    }

    public void removeObserver(Observer obv){
        observerList.remove(obv);
    }

    public void updateContext(Double newTemp){
        Map<String, Double> mp = new TreeMap<>();
        mp.put("Temperature", newTemp);

        for(int i = 0;i < this.observerList.size(); i++){
            Observer obv = observerList.get(i);
            obv.updateContext(mp);
        }
    }
}
