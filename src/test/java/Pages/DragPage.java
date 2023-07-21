package Tests;

import Utilities.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class DragPage extends DriverManager {

    public DragPage() {

        PageFactory.initElements(getAndroidDriver(),this);
    }

    public AppiumBy dragMenu = new AppiumBy.ByAccessibilityId("Drag");
    public By dragAndDropLogo = By.xpath("//*[@text='Drag and Drop']");
}
