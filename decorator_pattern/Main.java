package decorator_pattern;

import java.util.Map;
import java.util.TreeMap;

import decorator_pattern.DecoratorPatternTestCaseRunner;
import testcase_executor.TestCaseExecutor;
import testcase_executor.testcase_runner.TestCaseRunner;

public class Main {
    public static void main(String[] args){        
        Map<String, String> params = new TreeMap<>();
        params.put("reader_type", "file");
        params.put("reader_type", "terminal");
        params.put("filename", "test-cases/t3.txt");
        System.out.println("Enter 'help' to see all available commands!!");
        TestCaseRunner runnerObj = new DecoratorPatternTestCaseRunner();
        TestCaseExecutor executorObj = new TestCaseExecutor(params, runnerObj);
        executorObj.execute();
    }
}
