package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    public void configureRwport(){
        
    }

    public void onTestStart(ITestResult result) {
        System.out.println("On start method invoked...");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(" Passed test cases"+ result.getName());


    }

    public void onTestFailure(ITestResult result) {
        System.out.println(" failed test cases"+ result.getName());

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(" skipped test name"+ result.getName());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("test fail but within test name"+ result.getName());

    }

    public void onStart(ITestContext context) {

        System.out.println("Hello, the test is passed........");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test is finished but you have ");
    }
}
