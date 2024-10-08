package listenersUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseUtility.BaseClass;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class ListenerImplementationClass implements ITestListener, ISuiteListener
{
	public ExtentReports report; //code is related to ExtentReports code.	
	public ExtentTest test;      //code is related to ExtentReports code.	
	
	@Override
	public void onStart(ISuite suite) 
	{
		JavaUtility jutil= new JavaUtility();
		String time = jutil.getCurrentDateAndTimeForSS();
		System.out.println("Execution started and report configuration");
		
//Below code is related to ExtentReports code.		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html"); // no need to create the separete folder manually, automatically it will create the folder.
		spark.config().setDocumentTitle("VTIGER_CRM");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Browser", "Chrome");
		
	}

	@Override
	public void onFinish(ISuite suite) 
	{
		System.out.println("Exdecution completed and Report Backup");
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
	    String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"==START==");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		 String methodName = result.getMethod().getMethodName();
			System.out.println(methodName+"==SUCCESS==");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		 String methodName = result.getMethod().getMethodName();
			System.out.println(methodName+"==FAILED==");
			WebDriverUtility wutil = new WebDriverUtility();
			JavaUtility jutil = new JavaUtility();                   //1.calling java utility for getting the date and time stamp. added on 27-Sep-2024
			String dateAndTime = jutil.getCurrentDateAndTimeForSS(); //2.getting date and time stamp into variable. added on 27-Sep-2024
			try {
				wutil.takeScreenShotOfWebPage(BaseClass.sdriver, methodName+"_"+dateAndTime);  //3.here am adding the date&time format on 27-Sep-2024 to add the date and time stamp on the errorshot file name.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 String methodName = result.getMethod().getMethodName();
			System.out.println(methodName+"==SKIPPED==");
	}
	
	

}
