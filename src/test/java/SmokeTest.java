import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import pages.HomeScreenPage;
import pages.InnerApiDemosPage;
import pages.LogTextBoxPage;
import utils.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class SmokeTest  {

    private static AndroidDriver driver;
    private HomeScreenPage homeScreen;
    private InnerApiDemosPage innerApiDemoScreen;
    private LogTextBoxPage logTextBoxPage;

    @BeforeSuite
    public void DesiredCapabilities() throws MalformedURLException {
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);

        File app = new File("ApiDemos-debug.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        driver = new AndroidDriver(url, caps);
        homeScreen = new HomeScreenPage(driver);
        innerApiDemoScreen = new InnerApiDemosPage(driver);
        logTextBoxPage = new LogTextBoxPage(driver);
    }


    @Test
    public void test_login() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        homeScreen.verifyHeader();
        homeScreen.selectTextButton();

        innerApiDemoScreen.verifyHeader();
        innerApiDemoScreen.selectLogTextBoxButton();

        logTextBoxPage.verifyHeader();
        logTextBoxPage.selectAddButton();

        String expectedPanelText = "This is a test";
        String actualPanelText = logTextBoxPage.getPanelText();

        System.out.println("Checking panel text...");

        TestUtils.outputIfMatchPassOrFail(expectedPanelText, actualPanelText);
        assertThat(actualPanelText,containsString(expectedPanelText));
    }

    @AfterSuite
    public void tearDownAppium() throws Exception {
        System.out.println("\nTearing Down Driver.");
        driver.quit();
    }
}
