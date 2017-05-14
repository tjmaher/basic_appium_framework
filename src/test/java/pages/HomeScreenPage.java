package pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomeScreenPage {

    private AndroidDriver driver;

    @AndroidFindBy(id = "android:id/action_bar")
    private MobileElement header;

    @AndroidFindBy(accessibility = "Text")
    private MobileElement textButton;

    public HomeScreenPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public void verifyHeader(){
        System.out.println("HOME_SCREEN_PAGE: Verifying Header appears.");
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    public void selectTextButton(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(this.textButton));

        System.out.println("HOME_SCREEN_PAGE: Selecting [TEXT] button.\n");
        this.textButton.click();
    }
}
