package strategy_pattern.strategy;

import java.util.Map;

public abstract class RouteStrategy {
    private String strategyType;

    /*
     * Let's assume navigate simple gives the directions in order to reach point A-to-B
     */
    public abstract String navigate(String uniqueId, float src, float dst, Map<String, Integer> otherParams);
    /*
     * This is responsible to calculate how much time it will take to reach following the route
     */
    public abstract float estimateTimeOfArrival(String route);

    public String toString(){
        return strategyType;
    }

    protected void setStrategy(String strategyType){
        this.strategyType = strategyType;
    }

}
