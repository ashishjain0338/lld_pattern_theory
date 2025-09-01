package observer_pattern;

import testcase_executor.testcase_runner.TestCaseRunner;
import observer_pattern.Observables.*;
import observer_pattern.Observables.Observable;
import observer_pattern.Observer.Observer;
import observer_pattern.factory.ObserverFactory;

import java.util.*;

public class ObservablePatternTestCaseRunner extends TestCaseRunner {
    HashMap<String, Observable> svcMap = new HashMap<>();
    HashMap<String, Observer> userMap = new HashMap<>();

    String helpStr = """
            1. help: Prints the help-Strategy
            2. reset: Reset the Current-state
            3. state: Prints the Current-state
            4. Add Rainfall/temperature service (Obeservable)
               Syntax: add service <service-type> <service-id>
               Refer: add service <rain, temp> <service-id>
            5. Remove Rainfall/temperature service
                remove service <service-id>
            6. Create a user (Observer)
                Syntax: add user <user-type> <userid>
                Refer: add user <mobile, big-screen, bot> <userid>
            7. Remove user (Observer)
                remove user <userid>
            8. Subscribe user to a service:
                subscribe <userid> <serviceid>
            9. Unsubscribe user from a service
                unsubscribe <userid> <serviceid>
            10. Change value of service (observable)
                update <serviceid> <new-value>
            11. exit
""";

    
    
    void showState(){
        System.out.println("---------------------------- XXXXXXXXXXXXXXXXXXXXXXXX ------------------------------");
        System.out.println("User-List are");
        this.userMap.forEach((_, userObj) -> {
            System.out.println(userObj.toString());
        });
        System.out.println("----------------------------------------------------------------------------------------");
        this.svcMap.forEach((serviceId, svc_obj) -> {
            System.out.printf("ServiceId : %s, %s\n", serviceId, svc_obj.toString());
        });
        System.out.println("---------------------------- XXXXXXXXXXXXXXXXXXXXXXXX ------------------------------");
    }                        

    //     this.state.remove(userid);
    // }

    void addService(String svcType, String svcId){
        if(this.svcMap.containsKey(svcId)){
            System.out.printf("Service with given Id : %s already exists\n", svcId);
            return;
        }

        Observable obj = null;
        switch (svcType) {
            case "rain":
                obj = new RainfallPredictorService();
                break;
            case "temp":
                obj = new TemperatureService();
                break;
            default:
                System.out.printf("Invalid Service-Type : '%s', Allowed Service-types are [rain, temp]\n", svcType);
                return;
        }
        this.svcMap.put(svcId, obj);

    }

    void removeService(String svcId){
        if(!this.svcMap.containsKey(svcId)){
            System.out.printf("Given Service-id %s Doesn't exist\n", svcId);
            return;
        }
        this.svcMap.remove(svcId);
    }

    void addUser(String userType, String userId){
        if(this.userMap.containsKey(userId)){
            System.out.printf("User with userID %s Already exists\n", userId);
            return;
        }
        Observer user = ObserverFactory.getObserverObj(userType, userId);
        userMap.put(userId, user);
    }

    void removeUser(String userId){
        if(!this.userMap.containsKey(userId)){
            System.out.printf("User with user-id: %s doesn't exist\n", userId);
            return;
        }

        Observer obv = userMap.get(userId);
        // Unsubscribe from each service
        this.svcMap.forEach((serviceId, svc_obj) -> {
            svc_obj.removeObserver(obv);
        });

        userMap.remove(userId);
    }

    void subscribe(String svcId, String userId){
        if(!this.svcMap.containsKey(svcId)){
            System.out.printf("Given Service-id %s Doesn't exist\n", svcId);
            return;
        }
        if(!this.userMap.containsKey(userId)){
            System.out.printf("User with user-id: %s doesn't exist\n", userId);
            return;
        }
        Observer obv = this.userMap.get(userId);
        Observable svc = this.svcMap.get(svcId);
        svc.addObserver(obv);
    }
    
    void unsubscribe(String svcId, String userId){
        if(!this.svcMap.containsKey(svcId)){
            System.out.printf("Given Service-id %s Doesn't exist\n", svcId);
            return;
        }
        if(!this.userMap.containsKey(userId)){
            System.out.printf("User with user-id: %s doesn't exist\n", userId);
            return;
        }
        Observer obv = this.userMap.get(userId);
        Observable svc = this.svcMap.get(svcId);
        svc.removeObserver(obv);
    }

    void updateSvcValue(String svcId, Double newVal){
        if(!this.svcMap.containsKey(svcId)){
            System.out.printf("Given Service-id %s Doesn't exist\n", svcId);
            return;
        }
        Observable svc = this.svcMap.get(svcId);
        svc.updateContext(newVal);
    }
    
    @Override
    public boolean addressSingleLine(String line) {
        try {
            String[] words = line.split(" ");
            if (words.length == 0)
                return false;
            String cmd = words[0];
            /*
             * Since,It is NOT a production code, and only for learning,
             * User's input is NOT validated, If user give invalid input,
             * It won't fail, but will say, Error has been encountered
             */
            switch (cmd) {
                case "help":
                    System.out.println(this.helpStr);
                    break;
                case "reset":
                    this.svcMap = new HashMap<>();
                    this.userMap = new HashMap<>();
                    break;
                case "state":
                    showState();
                    break;
                case "exit":
                    return true;
                case "add":
                    String AddcmdType = words[1];
                    if("service".equals(AddcmdType)){
                        // Adding Observable Service
                        this.addService(words[2], words[3]);
                    }else if("user".equals(AddcmdType)){
                        this.addUser(words[2], words[3]);
                    }else{
                        System.out.println("Invalid add command");
                    }
                    break;
                case "remove":
                    String removeCmdType = words[1];
                    if("service".equals(removeCmdType)){
                        // Adding Observable Service
                        this.removeService(words[2]);
                    }else if("user".equals(removeCmdType)){
                        this.removeUser(words[2]);
                    }else{
                        System.out.println("Invalid remove command");
                    }
                    break;
                case "subscribe":
                    this.subscribe(words[1], words[2]);
                    break;
                case "unsubscribe":
                    this.subscribe(words[1], words[2]);
                    break;
                case "update":
                    this.updateSvcValue(words[1], Double.parseDouble(words[2]));
                    break;
                default:
                    System.out.println("Invalid command : " + line);
                    break;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error Encountered with line " + line + "\nError : " + e.getMessage());
            return false;
        }

    }
}

