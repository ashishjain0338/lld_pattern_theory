// EmailDecorators.java
package decorator_pattern.EmailNotification.decorators;

import decorator_pattern.EmailNotification.EmailNotification;
import decorator_pattern.model.EmailContent;

public abstract class EmailDecorators implements EmailNotification{
    EmailNotification emailObj;

    public EmailDecorators(EmailNotification emailObj){
        this.emailObj = emailObj;
    }

    @Override
    public EmailContent prepareMessage(){
        // Prepare Message will always backtracks to get the base-message, and then will build on top of it
        return this.emailObj.prepareMessage();
    }


    @Override
    public void send(){
        System.out.println(prepareMessage().toString());
    }

    @Override
    public String toString(){
        String backtrackedStr = this.emailObj.toString();

        return String.format("EmailDecorators(%s)", backtrackedStr);
    }
}
