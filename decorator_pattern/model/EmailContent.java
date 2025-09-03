// EmailContent.java

package decorator_pattern.model;

import java.util.ArrayList;

public class EmailContent {
    public ArrayList<String> headers;
    public ArrayList<String> body;
    public ArrayList<String> footer;

    public EmailContent(){
        this.headers = new ArrayList<>();
        this.body = new ArrayList<>();
        this.footer = new ArrayList<>();
    }

    String convertArrayListToString(ArrayList<String> input){
        String out = "";
        for(String msg : input){
            out += (msg + "\n");
        }
        return out;

    }

    public String toString(){
        String out = "";
        out += "============ HEADER ================\n";
        out += convertArrayListToString(headers);
        out += "============ BODY ================\n";
        out += convertArrayListToString(body);
        out += "============ FOOTER ================\n";
        out += convertArrayListToString(footer);

        return out;
    }
}
