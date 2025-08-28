package strategy_pattern.strategy;

import java.util.Map;

public class ShortestDistanceRouteFinding extends RouteStrategy{
    
    public ShortestDistanceRouteFinding(){
        this.setStrategy("shortest-distance");
    }

    public String navigate(String uniqueId, float src, float dst, Map<String, Integer> otherParams){
        // Assume some Heavy Algo
        System.out.printf("ShortestDistance RouteFinding of %s from %s to %s\n Speed Vector is (%s, %s)\n"
        ,uniqueId, src, dst, otherParams.get("min-speed"), otherParams.get("max-speed"));
        return "abc";
    }

    public float estimateTimeOfArrival(String route){
        return 54f;
    }
}
