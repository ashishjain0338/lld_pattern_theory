package strategy_pattern;

import java.util.Map;
import java.util.TreeMap;

import testcase_executor.TestCaseExecutor;
import testcase_executor.testcase_runner.TestCaseRunner;

public class Main {
    public static void main(String[] args){
        Map<String, String> params = new TreeMap<>();
        // params.put("reader_type", "file");
        params.put("reader_type", "terminal");
        params.put("filename", "test-cases/t1.txt");

        TestCaseRunner runnerObj = new StrategyPatternTestCaseRunner();
        TestCaseExecutor executorObj = new TestCaseExecutor(params, runnerObj);
        executorObj.execute();
    }
}
