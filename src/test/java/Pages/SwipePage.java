package Tests;

import Utilities.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class SwipePage extends DriverManager {

    public SwipePage() {
        PageFactory.initElements(getAndroidDriver(),this);

    }

    public AppiumBy swipeMenu = new AppiumBy.
            ByAccessibilityId("Swipe");
    public By swipePageText = By.
            xpath("//*[@text='Swipe horizontal']");
    public AppiumBy swipePageLogo =new  AppiumBy
            .ByAccessibilityId("WebdriverIO logo");
    public By allButtons = By.xpath("//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup");

    public By swipeLogoText = By.xpath("//*[@text='You found me!!!']");
    public By compatibleText = By.xpath("//*[@text='COMPATIBLE']");
}
