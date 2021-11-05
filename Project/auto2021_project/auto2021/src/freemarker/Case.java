package freemarker;

public class Case {
//    private int id;

    private String testMethod;

    private String result;

    private String failResult;


    public Case() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Case( String testMethod, String result, String failResult) {
        super();

        this.testMethod = testMethod;
        this.result = result;
        this.failResult = failResult;
    }


    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFailResult() {
        return failResult;
    }

    public void setFailResult(String failResult) {
        this.failResult = failResult;
    }
}
