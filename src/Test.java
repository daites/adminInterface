
public class Test {
    private int testId;
    private String testName;

    public Test(String userInputName, int currentMasterTestId) {
        testName = userInputName;
        testId = currentMasterTestId;
    }

    public int getTestId() {
        return testId;
    }

    public String getTestName() {
        return testName;
    }
}
