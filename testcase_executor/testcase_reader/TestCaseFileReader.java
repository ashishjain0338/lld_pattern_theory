package testcase_executor.testcase_reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import utils.utils;

public class TestCaseFileReader extends TestCaseReader{
    String filename = "";
    BufferedReader br = null;

    public TestCaseFileReader(Map<String, String> params){
        this.setup_config(params);
    }


    public void setup_config(Map<String, String> params){
        String[] required_config = {"filename"};
        if(!utils.validate_map(params, required_config)){
            throw new Error("Invalid params config for TestFileReader");
        }

        this.filename = params.get("filename");
        try{
            this.br = new BufferedReader(new FileReader(this.filename));
        } catch (IOException e) {
            throw new Error("Unable to open file with : " + this.filename);
        }
    }

    public String readNextLine(){
        if (this.br == null){
            throw new Error("Buffer-Reader is not set| File has not been read| Exiting!!");
        }
        try{
            return br.readLine();
        } catch (IOException e){
            throw new Error("Unable to read next line");
        }
    }
    
}
