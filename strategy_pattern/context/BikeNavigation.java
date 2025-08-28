package strategy_pattern.context;

import java.util.Map;

public class BikeNavigation extends Navigation {
    public BikeNavigation(String uniqueId){
        super(uniqueId, "distance");
    }

    public String toString(){
        return "bike";
    }

    /*
     * Example: where context is used to do something by concrete class.
     */
    @Override
    float calculateCurrentSpeed() {
        // Has some Alogorithm to calculate speed based on curPos
        return curPos / 10;
    }

    public void navigate(float dst){
        // After Some Calculations, we set otherParams
        Map<String, Integer> otherParams = Map.of(
            "max-speed", 50,
            "min-speed", 10
        );
        rtStrategy.navigate(uniqueId, curPos, dst, otherParams);
    }

    
}
