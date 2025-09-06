// TextEmail.java
package decorator_pattern.EmailNotification;

import decorator_pattern.model.EmailContent;

public class TextEmail implements EmailNotification{
    String body = "";

    public TextEmail(String body){
        this.body = body;
    }
    
    public EmailContent prepareMessage(){
        EmailContent emailContentObj = new EmailContent();
        emailContentObj.body.add(this.body);
        return emailContentObj;
    }

    public void send(){
        System.out.println(this.prepareMessage().toString());
    }

    @Override
    public String toString(){
        return String.format("TextEmail(body='%s')", this.body);
    }
    
}
