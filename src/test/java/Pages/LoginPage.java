package Tests;

import Utilities.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverManager {

    public LoginPage(){
        PageFactory.initElements(getAndroidDriver(),this);
    }

    public AppiumBy loginMenu = new AppiumBy.ByAccessibilityId("Login");
    public AppiumBy usernameInputField = new AppiumBy.ByAccessibilityId("input-email");
    public AppiumBy passwordInputField = new AppiumBy.ByAccessibilityId("input-password");
    public By successLoginMessage = By.id("android:id/message");
    public AppiumBy loginButton = new AppiumBy.ByAccessibilityId("button-LOGIN");
    public  By loginOkButton = new By.ById("android:id/button1");
}
