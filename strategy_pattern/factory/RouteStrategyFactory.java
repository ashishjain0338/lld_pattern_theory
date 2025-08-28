package strategy_pattern.factory;

import strategy_pattern.strategy.*;

public class RouteStrategyFactory {
    public static RouteStrategy getRouteObj(String reqStrategy){
        switch (reqStrategy) {
            case "time":
                return new ShortestTimeRouteFinding();
            case "distance":
                return new ShortestDistanceRouteFinding();
            case "scenic":
                return new ScenicTimeRouteFinding();
            default:
                System.out.printf("Invalid reqStrategy %s, Falling back to default", reqStrategy);
                break;
        }
        // Default Strategy
        return new ShortestTimeRouteFinding();
    } 
}
