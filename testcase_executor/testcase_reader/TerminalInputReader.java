package testcase_executor.testcase_reader;

import java.util.Map;
import java.util.Scanner;

public class TerminalInputReader extends TestCaseReader{
    Scanner scanner = null;
    
    public TerminalInputReader(){
        this.setup_config(null);
    }
    
    public void setup_config(Map<String, String> params){
        this.scanner = new Scanner(System.in);
    }

    public String readNextLine(){
        return scanner.nextLine();
    }
}
