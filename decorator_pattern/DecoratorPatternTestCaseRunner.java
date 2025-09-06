package decorator_pattern;

import testcase_executor.testcase_runner.TestCaseRunner;


import java.util.*;

// import decorator_pattern.EmailNotification.EmailNotification;
import decorator_pattern.EmailNotification.*;
import decorator_pattern.EmailNotification.decorators.*;;

public class DecoratorPatternTestCaseRunner extends TestCaseRunner {
    HashMap<String, EmailNotification> emailMap = new HashMap<>();

    String helpStr = """
---------------------------------------------------------------------------------------        
    1. help: Prints the help-Strategy
    2. reset: Reset the Current-state
    3. state: Prints the Current-state
    4. add Email Content
        Syntax: add <emailId> <email-body (single-line)>
    5. update email (Add additional features)
        Syntax: update <emailId> <additional-feature> <additionl-params>
        Refer: update <emailId> <compress, encrypt, attachfile>
                a. update <emailId> <attachfile> <filename> <filetype>
                b. update <emailId> <encrypt> <encryptionMethod, default = base64>
    6. send Email
        Syntax: send <EmailId>
    7. remove <EmailId>
    8. exit
---------------------------------------------------------------------------------------
""";

    
    
    void showState(){
        System.out.println("---------------------------- XXXXXXXXXXXXXXXXXXXXXXXX ------------------------------");
        this.emailMap.forEach((emailID, emailObj) -> {
            System.out.println(emailID + ": " + emailObj.toString());
        });
        System.out.println("---------------------------- XXXXXXXXXXXXXXXXXXXXXXXX ------------------------------");
    }
    
    void addEmail(String emailId, String body){
        if(this.emailMap.containsKey(emailId)){
            System.out.printf("Email with emailId : %s already Exists!\n", emailId);
            return;
        }

        EmailNotification emailObj = new TextEmail(body);
        emailMap.put(emailId, emailObj);
    }

    void removeEmail(String emailId){
        if(!this.emailMap.containsKey(emailId)){
            System.out.printf("Email with emailId : %s doesn't Exists!\n", emailId);
            return;
        }
        emailMap.remove(emailId);
    }

    void sendEmail(String emailId){
        if(!this.emailMap.containsKey(emailId)){
            System.out.printf("Email with emailId : %s doesn't Exists!\n", emailId);
            return;
        }
        emailMap.get(emailId).send();
    }

    void updateEmail(String emailId, String featureType, String[] params){
        if(!this.emailMap.containsKey(emailId)){
            System.out.printf("Email with emailId : %s doesn't Exists!\n", emailId);
            return;
        }

        EmailNotification emailObj = emailMap.get(emailId);
        EmailNotification newEmailObj = null;
        switch (featureType) {
            case "compress":
                newEmailObj = new CompressMessageDecorator(emailObj);
                break;
            case "encrypt":
                String encryptionMethod = (params.length == 0 ? null : params[0]); 
                newEmailObj = new EncryptMessageDecorator(emailObj, encryptionMethod);
                break;
            case "attachfile":
                if(params.length < 2){
                    System.out.printf("Invalid Parameters Provided: %s\n", String.join(", ", params));
                    return;
                }
                newEmailObj = new AttachFileDecorator(emailObj, params[0], params[1]);
                break;
            default:
                System.out.printf("Invalid additional feature: %s\n", featureType);
                return;
        }
        emailMap.put(emailId, newEmailObj);
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
                    this.emailMap = new HashMap<>();
                    break;
                case "state":
                    showState();
                    break;
                case "add":
                    // Combine all words after first two-word
                    String emailBody = "";
                    for(int i = 2; i < words.length; i++){
                        emailBody += (words[i] + " ");
                    }
                    if(emailBody.equals("")){
                        System.out.println("Empty Email Body detected, Please provide email body");
                    }
                    this.addEmail(words[1], emailBody);

                    break;
                case "remove":
                    this.removeEmail(words[1]);
                    break;
                case "send":
                    this.sendEmail(words[1]);
                    break;
                case "update":
                    String[] params = Arrays.copyOfRange(words, 3, words.length);
                    this.updateEmail(words[1], words[2], params);
                    break;

                case "exit":
                    return true;
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

