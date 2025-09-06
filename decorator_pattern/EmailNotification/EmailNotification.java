// EmailNotification.java
package decorator_pattern.EmailNotification;

import decorator_pattern.model.EmailContent;

public interface EmailNotification {

    public EmailContent prepareMessage();
    public void send();
    public String toString();
}
