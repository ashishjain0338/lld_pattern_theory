// EncryptMessageDecorator.java
package decorator_pattern.EmailNotification.decorators;

import decorator_pattern.EmailNotification.EmailNotification;
import decorator_pattern.model.EmailContent;

public class EncryptMessageDecorator extends EmailDecorators{
    String encryptionMethod = "base64";

    public EncryptMessageDecorator(EmailNotification emailObj, String encryptionMethod){

        super(emailObj);
        if(encryptionMethod != null){
            this.encryptionMethod = encryptionMethod;
        }
        
    }

    @Override
    public String toString(){
        String backtrackedStr = this.emailObj.toString();

        return String.format("Encrypt(encryptionMethod=%s,%s)", this.encryptionMethod, backtrackedStr);
    }


    public EmailContent prepareMessage(){
        EmailContent emailContent = this.emailObj.prepareMessage();
        String msg = String.format("Message encrpyted with %s Encryption", this.encryptionMethod);
        emailContent.footer.add(msg);

        for(int i = 0;i < emailContent.body.size(); i++){
            emailContent.body.set(i, this.encryptMessage(emailContent.body.get(i)));
        }

        return emailContent;
    }

    String encryptMessage(String input){
        if ("base64".equalsIgnoreCase(encryptionMethod)) {
            return java.util.Base64.getEncoder().encodeToString(input.getBytes());
        }
        return input;
    }


    
}
