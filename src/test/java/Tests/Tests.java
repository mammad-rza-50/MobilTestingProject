package Tests;

import Pages.*;
import Utilities.*;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Tests extends DriverManager {

    AndroidDriver driver;
    WebDriverWait wait;

     LoginPage loginPage = new LoginPage();
    FormPage formPage = new FormPage();

   SwipePage swipePage = new SwipePage();
  PageActionsHelper actionsHelper = new PageActionsHelper();
    DragPage dragPage = new DragPage();


    @BeforeTest
    public void setup() {
        driver = getAndroidDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(14));
    }

    @Test
    public void LoginFunctionTest() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(getAndroidDriver(), Duration.ofSeconds(20));
        Thread.sleep(2000);
        getAndroidDriver().findElement(loginPage.loginMenu).click();
        getAndroidDriver().findElement(loginPage.usernameInputField).sendKeys("username123@gmail.com");
        getAndroidDriver().findElement(loginPage.passwordInputField).sendKeys("parola123!");
        getAndroidDriver().findElement(loginPage.loginButton).click();
        String actualText =
                wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.successLoginMessage)).getText();
        Assert.assertEquals(actualText, "You are logged in!");
        // By loginOkButton = new By.ById("android:id/button1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginOkButton));
        getAndroidDriver().findElement(loginPage.loginOkButton).click();
        Thread.sleep(3000);

    }

    @Test
    public  void dropDown() {

        getAndroidDriver().findElement(formPage.formButton).click();
        getAndroidDriver().findElement(formPage.dropDown).click();
        getAndroidDriver().findElement(formPage.selectDropDown2).click();
        System.out.println("selected option is = " + getAndroidDriver().findElement(formPage.actualselectedOption).getText());
        getAndroidDriver().findElement(formPage.dropDown).click();
        String isSelected = getAndroidDriver().findElement(formPage.selectDropDown2).
                getAttribute("checked");
        Assert.assertEquals(isSelected, "true");
        System.out.println("Is element selected= " + isSelected);

    }

    @Test
    public  void swich() {

        getAndroidDriver().findElement(formPage.formButton).click();
        String switchTextBeforeClik = getAndroidDriver().findElement(formPage.swichText).getText();
        Assert.assertEquals(switchTextBeforeClik, "Click to turn the switch ON");
        System.out.println("Swich text before click= " + switchTextBeforeClik);
        getAndroidDriver().findElement(formPage.swichButton).click();
        String switchTextAfterClik = getAndroidDriver().findElement(formPage.swichText).getText();
        Assert.assertEquals(switchTextAfterClik, "Click to turn the switch OFF");
        System.out.println("Swich text after click= " + switchTextAfterClik);

    }

    @Test
    public void ScroolDown() {

        getAndroidDriver().findElement(swipePage.swipeMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.swipePageText));
        actionsHelper.performScroll("down");
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.swipePageLogo));
        Assert.assertTrue(getAndroidDriver().findElement(swipePage.swipePageLogo).isDisplayed());
        if (getAndroidDriver().findElement(swipePage.swipeLogoText).isDisplayed()) {
            System.out.println("I found You!!!");
        }

    }


    @Test
    public void ScroolToRightEnd() {

        getAndroidDriver().findElement(swipePage.swipeMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.swipePageText));

        List<WebElement> listOfButtons = getAndroidDriver().findElements(swipePage.allButtons);
        for (int i = 0; i < listOfButtons.size(); i++) {
            actionsHelper.performScroll("right");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.compatibleText));
        Assert.assertTrue(getAndroidDriver().findElement(swipePage.compatibleText).isDisplayed());
        if (getAndroidDriver().findElement(swipePage.compatibleText).isDisplayed()) {
            System.out.println("Compatible page");
        }

    }

    @Test
    public void DragAndDrop() {

        getAndroidDriver().findElement(dragPage.dragMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dragPage.dragAndDropLogo));


    }


    @AfterTest
    public void tearDown() {

        if (driver != null) {
            getAndroidDriver().quit();
        }
    }
}