package Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("extent.html");
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = getInstance().createTest(testName);
        return test;
    }

    private static void createInstance(String reportFileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileName);
        // Customize the report Structue
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("BDD Test Report");
        htmlReporter.config().setReportName("Test Automation Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
