package observer_pattern.factory;
import observer_pattern.Observer.*;


public class ObserverFactory {
    public static Observer getObserverObj(String ObserverType, String id){
        Observer myObj = null;
        switch (ObserverType) {
            case "mobile":
                myObj = new MobileObserver(id);
                break;
            case "big-screen":
                myObj = new BigScreenObserver(id);
                break;
            case "bot":
                myObj = new BotObserver(id);
                break;
            default:
                System.out.printf("Invalid Observer-type %s (by ObserverFactory)\n", ObserverType);
                break;
        }
        return myObj;
    } 
}
