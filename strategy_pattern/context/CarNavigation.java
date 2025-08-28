package strategy_pattern.context;

public class CarNavigation extends Navigation{

    public CarNavigation(String uniqueId){
        super(uniqueId, "time");
    }

    public String toString(){
        return "car";
    }

    /*
     * Example: where context is used to do something by concrete class.
     */
    @Override
    float calculateCurrentSpeed() {
        // Has some Alogorithm to calculate speed based on curPos
        return curPos / 100;
    }

    // The Navigate is taken to be default
}
