package testcase_executor.testcase_reader;

import java.util.Map;

abstract public class TestCaseReader {
    public abstract void setup_config(Map<String, String> params);
    public abstract String readNextLine();
}
