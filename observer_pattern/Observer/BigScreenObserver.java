package observer_pattern.Observer;
import utils.utils;
import java.util.Map;

public class BigScreenObserver extends BaseObserver{
    public BigScreenObserver(String id){
        super(id);
    }

    @Override
    public void updateContext(Map<String, Double> data){
        System.out.printf("Big-Screen User with userid : %s says: ", this.id);
        utils.printMap(data);   
    }
}
