
package reporting;

import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.File;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;
    private static ITestContext context;

    public synchronized static ExtentReports getInstance(){
        if(extent == null){
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(),"html");

            Date date = new Date();
            String fileName = "TestReport_"+date.toString().replace(" ", "_").replace(":", "-")+".html";

            extent = new ExtentReports(System.getProperty("user.dir")+"/lib/Reports/"+fileName,false);
            Reporter.log("Extent Report Directory"+ resultDirectory, true);
            extent.addSystemInfo("Host Name", "TEAM 3").addSystemInfo("Environment","QA")
              .addSystemInfo("User Name", "Elyamine Adjoudj");
            
          extent.loadConfig(new File(System.getProperty("user.dir")+ "/report-config.xml"));
        }
        return extent;
    }

    public static void setOutputDirectory(ITestContext context){
        ExtentManager.context = context;

    }
}