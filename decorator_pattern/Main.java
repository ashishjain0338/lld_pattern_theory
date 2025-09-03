package decorator_pattern;

import decorator_pattern.EmailNotification.EmailNotification;
import decorator_pattern.EmailNotification.TextEmail;
import decorator_pattern.EmailNotification.decorators.AttachFileDecorator;
import decorator_pattern.EmailNotification.decorators.CompressMessageDecorator;
import decorator_pattern.EmailNotification.decorators.EncryptMessageDecorator;

public class Main {
    public static void main(String[] args){
        EmailNotification email1 = new TextEmail("Hello-World");
        EmailNotification email2 = new AttachFileDecorator(email1, "image.png", "png");
        EmailNotification email3 = new EncryptMessageDecorator(email2, null);
        EmailNotification email4 = new CompressMessageDecorator(email3);
        
        email4.send();
    }
}
