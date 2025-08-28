package strategy_pattern.context;

import java.util.Map;

public class WalkNavigation extends Navigation{
    public WalkNavigation(String uniqueId){
        // The default route-finding strategy of walk is scenic
        super(uniqueId, "scenic");
    }

    public String toString(){
        return "walk";
    }

    /*
     * Example: where context is used to do something by concrete class.
     */
    @Override
    float calculateCurrentSpeed() {
        // Has some Alogorithm to calculate speed based on curPos
        return curPos;
    }

    public void navigate(float dst){
        Map<String, Integer> otherParams = Map.of(
            "max-speed", 10,
            "min-speed", 0
        );
        rtStrategy.navigate(uniqueId ,curPos, dst, otherParams);
    }
}
