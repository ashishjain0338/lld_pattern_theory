package strategy_pattern.strategy;

import java.util.Map;

public class ScenicTimeRouteFinding extends RouteStrategy{
    public ScenicTimeRouteFinding(){
        this.setStrategy("scenic");
    }
    
    public String navigate(String uniqueId, float src, float dst, Map<String, Integer> otherParams){
        // Assume some Heavy Algo
        System.out.printf("Scenic RouteFinding of %s from %s to %s\n Speed Vector is (%s, %s)\n"
        , uniqueId, src, dst, otherParams.get("min-speed"), otherParams.get("max-speed"));
        return "abc";
    }

    public float estimateTimeOfArrival(String route){
        return 5f;
    }
}
