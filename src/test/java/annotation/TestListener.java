package annotation;

import com.travelers.helper.DriveFactory;
import com.travelers.helper.SeleniumHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult iTestResult){
        try {
            SeleniumHelper.takeScreenshot(DriveFactory.getDriver());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
