package utils;
import java.util.Map;

public class utils {

    public static boolean validate_map(Map<String, String> mp, String[] required_keys){
        for(String keys: required_keys){
            if(!mp.containsKey(keys)){
                return false;
            }
        }
        return true;
    }

    public static <K, V> void printMap(Map<K, V> map) {
        if(map == null){
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
