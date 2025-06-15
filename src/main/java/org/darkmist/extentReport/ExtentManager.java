package org.darkmist.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentTest currentTest;


    public static void initReport() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setTimelineEnabled(true);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "UAT");
            extent.setSystemInfo("Tester", "Automation Team");
        }
    }

    // Create top-level test node for each test method
    public static void startTest(String testName, String description) {
        currentTest = extent.createTest(testName, description);
    }

    // Get the current test
    public static ExtentTest getTest() {
        return currentTest;
    }

    public static void flushReport() {
        extent.flush();
    }
}

