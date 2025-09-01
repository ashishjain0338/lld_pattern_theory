package observer_pattern.Observer;
import utils.utils;
import java.util.Map;

public class BotObserver extends BaseObserver{
    public BotObserver(String id){
        super(id, "bot");
    }

    @Override
    public void updateContext(Map<String, Double> data){
        System.out.printf("Bot User with userid : %s says: ", this.id);
        utils.printMap(data);   
    }
}
