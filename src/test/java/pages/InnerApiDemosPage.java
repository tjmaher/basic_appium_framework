package pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InnerApiDemosPage {

    private AndroidDriver driver;

    @AndroidFindBy(id = "android:id/action_bar")
    private MobileElement header;

    @AndroidFindBy(accessibility = "LogTextBox")
    private MobileElement logTextBoxButton;

    public InnerApiDemosPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public void verifyHeader(){
        System.out.println("INNER_API_DEMOS_PAGE: Verifying Header appears.");
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    public void selectLogTextBoxButton(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(this.logTextBoxButton));

        System.out.println("INNER_API_DEMOS_PAGE: Selecting [LogTextBox] button.\n");
        this.logTextBoxButton.click();
    }
}
