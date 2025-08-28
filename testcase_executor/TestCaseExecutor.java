package testcase_executor;

import testcase_executor.testcase_reader.*;
import testcase_executor.testcase_runner.TestCaseRunner;

import java.util.Map;
import utils.utils;
public class TestCaseExecutor {
    TestCaseReader readerObj;
    TestCaseRunner runnerObj;

    /*
     * The readerParams Must have a reader_type : name to specify the type of reader
     */
    public TestCaseExecutor(Map<String, String> readerParams, TestCaseRunner runnerObj){
        this.runnerObj = runnerObj;
        // Build ReaderObj
        String[] required_keys = {"reader_type"};
        if(!utils.validate_map(readerParams, required_keys)){
            throw new Error("Please provide right readerParams");
        }
        String readerType = readerParams.get("reader_type");
        switch (readerType) {
            case "file":
                readerObj = new TestCaseFileReader(readerParams);
                break;
            case "terminal":
                readerObj = new TerminalInputReader();
                break;
            default:
                throw new Error("Invalid Reader-type " + readerType);
        }

    }

    public void execute(){
        while(true){
            String line = this.readerObj.readNextLine();
            if(line == null){
                break;
            }
            // System.out.println("TestCaseExceutor :" + line);
            boolean needToExit = this.runnerObj.addressSingleLine(line);
            if(needToExit){
                System.out.println("Bye!!");
                break;
            }
            
        }
    }
}
