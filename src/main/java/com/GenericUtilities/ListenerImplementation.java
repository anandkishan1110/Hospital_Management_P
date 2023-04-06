package com.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener
      {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
    //execution start from here
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"----->Testscript execution started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+"---->Passed");
		Reporter.log(methodName+"-----> Testscript execution successfull");
	}

	public void onTestFailure(ITestResult result) {
//		String res = result.getName();
//		TakesScreenshot t=(TakesScreenshot)BaseClass.edriver;
//		File src = t.getScreenshotAs(OutputType.FILE);
//		File des=new File("./Screenshot/"+res+".png");
//		try {
//			FileUtils.copyFile(src, des);
//		} catch (IOException e) {
//			
//		}
//		
		try {
			String screenshotname = WebDriverUtility.getScreenShot(BaseClass.edriver,result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotname);
		} catch (Throwable e) {
		
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("Testscript execution failed");
	}   

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"---->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("Testscript execution Skipped");
	}

	public void onStart(ITestContext context) {
		//create html
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtendReport/report"+JavaUtilitity.random()+".html");
		htmlreport.config().setDocumentTitle("SDET-47 Batch");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("HMS-Patient");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser","chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base_URL", "http://rmgtestingserver/domain/Hospital_Management_System/");
		report.setSystemInfo("Reporter Name", "Kishan");
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
