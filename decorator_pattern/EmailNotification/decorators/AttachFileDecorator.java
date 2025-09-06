// AttachFileDecorator.java
package decorator_pattern.EmailNotification.decorators;

import decorator_pattern.EmailNotification.EmailNotification;
import decorator_pattern.model.EmailContent;

public class AttachFileDecorator extends EmailDecorators{
    String filename = "", filetype = "";

    public AttachFileDecorator(EmailNotification emailObj, String filename, String filetype){
        super(emailObj);
        this.filename = filename;
        this.filetype = filetype;
    }

    @Override
    public EmailContent prepareMessage(){
        EmailContent emailContent = this.emailObj.prepareMessage();
        String msg = String.format("Attached file with name : %s of file-type : %s", this.filename, this.filetype, null);
        emailContent.footer.add(msg);
        return emailContent;
    }

    @Override
    public String toString(){
        String backtrackedStr = this.emailObj.toString();
        return String.format("AttachFile(filename=%s, filetype=%s, %s)", filename, filetype, backtrackedStr);
    }



    
}
