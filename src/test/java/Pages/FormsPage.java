package Pages;

import Utilities.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends DriverManager {

    public FormPage() {

        PageFactory.initElements(getAndroidDriver(),this);
    }

    public AppiumBy formButton = new AppiumBy.ByAccessibilityId("Forms");
    public AppiumBy dropDown = new AppiumBy.ByAccessibilityId("Dropdown");
    public By selectDropDown2 = By.xpath("//*[@text='Appium is awesome']");
    public  By actualselectedOption = By.xpath("//android.view." +
            "ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.widget.EditText");

    public AppiumBy swichText = new AppiumBy.ByAccessibilityId("switch-text");
    public AppiumBy swichButton = new AppiumBy.ByAccessibilityId("switch");


}
