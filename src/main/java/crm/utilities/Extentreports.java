package crm.utilities;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {


	ExtentSparkReporter htmlReporter;
    
    static ExtentReports extent;
    //helps to generate the logs in test report.
    static ExtentTest test;
    
    public Extentreports()
    {
    	 htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/extenttestReport.html");
	        
	        //initialize ExtentReports and attach the HtmlReporter
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
    }
    
    public static void extentReports()
    {
 
    	Extentreports report=new Extentreports();
    	
    	
    }
    
    
    public static void extentReportsTest(String TestcaseName)
    {
    	test = extent.createTest(TestcaseName, TestcaseName);
    	 
    }
    


	public static void extentReportsResults(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
	}
	
    
    
    
	
	
}
