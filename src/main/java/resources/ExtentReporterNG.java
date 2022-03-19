package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		//ExtentReports, ExtentSparkReporter
				String path=System.getProperty("user.dir")+"\\reports\\index.html";//u ll get roject path until extent reports
				// step 1: createobject
				ExtentSparkReporter reporter=new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Results");
				reporter.config().setDocumentTitle("Test Results");
				//this class is reponsible to drive all your report execution
				 extent =new ExtentReports();
				//main class ll knowledge of your object
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Karthi");
				return extent;
				
	}
}
