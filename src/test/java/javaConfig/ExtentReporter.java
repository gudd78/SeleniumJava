package javaConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extent;
	public static ExtentReports getExtReports() {
		String path = System.getProperty("user.dir") + ".\\results\\extentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("One Mazda Automation Test");
		reporter.config().setDocumentTitle("One Mazda Extent Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test", "Test Cases");
		
		return extent;
	}

}
