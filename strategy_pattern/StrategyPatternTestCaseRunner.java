package strategy_pattern;

import java.util.HashMap;

import strategy_pattern.context.*;
import testcase_executor.testcase_runner.TestCaseRunner;

public class StrategyPatternTestCaseRunner extends TestCaseRunner {
    HashMap<String, Navigation> state = new HashMap<>();

    String helpStr = """
            1. help: Prints the help-Strategy
            2. reset: Reset the Current-state
            3. state: Prints the Current-state
            4. Syntax: add <userid> <navigation-type>:
               Refer : add <userid> <bike, car, walk>
            5. remove <userid>
            6. change <userid> <new-routestrategy>
               Refer : change <userid> <scenic, distance, time>
            7. navigate <userid>
            8. exit
""";

    
    
    void showState(){
        System.out.println("---------------------------- XXXXXXXXXXXXXXXXXXXXXXXX ------------------------------");
        this.state.forEach((userid, nav_obj) -> {
            System.out.printf("Userid : %s, Navigation-type: %s, Route-Finding-Strategy: %s\n", userid, nav_obj.toString(), nav_obj.getRtStrategy().toString());
        });
        System.out.println("---------------------------- XXXXXXXXXXXXXXXXXXXXXXXX ------------------------------");
    }                        

    void addUser(String userid, String nav_type){
        if(state.containsKey(userid)){
            System.out.println("User Already Exists");
            return;
        }

        Navigation navObj = null;
        switch (nav_type) {
            case "bike":
                navObj = new BikeNavigation(userid);
                break;
            case "car":
                navObj = new CarNavigation(userid);
                break;
            case "walk":
                navObj = new WalkNavigation(userid);
                break;
            default:
                System.out.println("Invalid Nav_type " + nav_type);
                return;
        }
        state.put(userid, navObj);
    }

    void removeUser(String userid){
        this.state.remove(userid);
    }

    void changeRouteStrategy(String userid, String route_type){
        if(!this.state.containsKey(userid)){
            System.out.println("User " + userid + " doesn't exist");
            return;
        }
        Navigation user = this.state.get(userid);
        user.changeRouteStrategy(route_type);
    }

    void navigate(String userid){
        if(!this.state.containsKey(userid)){
            System.out.println("User " + userid + " doesn't exist");
            return;
        }
        Navigation user = this.state.get(userid);
        user.navigate(8);
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
                    this.state = new HashMap<>();
                    break;
                case "state":
                    showState();
                    break;
                case "add":
                    // The burden of providing correct input is on user
                    String userid = words[1];
                    String nav_type = words[2];
                    this.addUser(userid, nav_type);
                    break;
                case "remove":
                    removeUser(words[1]);
                    break;
                case "change":
                    changeRouteStrategy(words[1], words[2]);
                    break;
                case "navigate":
                    navigate(words[1]);
                    break;
                case "exit":
                    return true;
                default:
                    break;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error Encountered with line " + line + "\nError : " + e.getMessage());
            return false;
        }

    }
}
