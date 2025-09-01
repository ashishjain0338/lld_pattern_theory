package observer_pattern.Observer;

import java.util.Map;

public interface Observer {
    public void updateContext(Map<String, Double> data);
    public String toString();
    String getId();
}