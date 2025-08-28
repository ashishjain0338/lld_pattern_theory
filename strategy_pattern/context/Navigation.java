package strategy_pattern.context;
import java.util.Map;

import strategy_pattern.factory.RouteStrategyFactory;
import strategy_pattern.strategy.*;

public abstract class Navigation {
    RouteStrategy rtStrategy;
    float curPos = 0;
    String uniqueId = "null";
    abstract float calculateCurrentSpeed();

    Navigation(String uniqueId ,String routeStrategyType){
        // RouteStrategyFactory rtFactoryObj = new RouteStrategyFactory();
        // this.rtStrategy = rtFactoryObj.getRouteObj(routeStrategyType);
        this.uniqueId = uniqueId;
        this.rtStrategy = RouteStrategyFactory.getRouteObj(routeStrategyType);
    }

    // Default strategy is time
    Navigation(){
        this.rtStrategy = RouteStrategyFactory.getRouteObj("time");
    }

    public void changeRouteStrategy(String newStrategy) {
        System.out.printf("Changing the Route Strategy of %s from current %s to %s\n", 
        uniqueId, rtStrategy.toString(), newStrategy);
        this.rtStrategy = RouteStrategyFactory.getRouteObj(newStrategy);
    }

    /*
     * Default way to navigate
     */
    public void navigate(float dst){
        Map<String, Integer> defaultParams = Map.of(
            "max-speed", 100,
            "min-speed", 10
        );

        rtStrategy.navigate(uniqueId, curPos, dst, defaultParams);
    }
    
}
