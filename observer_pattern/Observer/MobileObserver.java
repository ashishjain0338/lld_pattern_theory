package observer_pattern.Observer;
import utils.utils;
import java.util.Map;

public class MobileObserver extends BaseObserver{
    public MobileObserver(String id){
        super(id, "mobile");
    }

    @Override
    public void updateContext(Map<String, Double> data){
        System.out.printf("Mobile User with userid : %s says: ", this.id);
        utils.printMap(data);   
    }
}
