// CompressMessageDecorator.java

package decorator_pattern.EmailNotification.decorators;

import decorator_pattern.EmailNotification.EmailNotification;
import decorator_pattern.model.EmailContent;

public class CompressMessageDecorator extends EmailDecorators{

    public CompressMessageDecorator(EmailNotification emailObj){
        super(emailObj);
        
    }

    String compress(String input){
        // Run-length Compression
        String out = "";
        int count = 1;
        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i) == input.charAt(i - 1)){
                count++;
            }else{
                out += String.format("%d%s", count, input.charAt(i - 1));
                count = 1;
            }
        }

        out += String.format("%d%s", count, input.charAt(input.length() - 1));

        return out;
    }

    public EmailContent prepareMessage(){
        EmailContent emailContent = this.emailObj.prepareMessage();
        String msg = String.format("Message Compressed using Run-length Compression!!");
        emailContent.headers.add(msg);

        for(int i = 0;i < emailContent.body.size(); i++){
            emailContent.body.set(i, this.compress(emailContent.body.get(i)));
        }
        return emailContent;
    }
}
