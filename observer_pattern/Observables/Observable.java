package observer_pattern.Observables;

import java.util.Map;

import observer_pattern.Observer.Observer;

public interface Observable {

    public void addObserver(Observer obv);
    public void removeObserver(Observer obv);
    public void updateContext(Double newContext);
}
