package localtest.pages;

import localtest.util.LoginData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Created by Iakov Volf on 2/19/2015.
 */
public class LoginPage extends Page {
    @FindBy(id = "divTasks")
     WebElement taskButton;
    @FindBy(id = "login_UserName_I")
     WebElement loginUsernameField;
    @FindBy(id = "login_Password_I")
     WebElement loginPasswordField;
    @FindBy(id = "login_Login_CD")
     WebElement loginButton;

    public LoginPage(WebDriver driver) {

        super (driver);
        this.PAGE_URL = "https://alphaex.insynctiveapps.com";
        this.PAGE_TITLE = "Login";
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public  LoginPage navigateTo(WebDriver driver) {
        driver.get("https://alphaex.insynctiveapps.com");
        return PageFactory.initElements(driver,
                LoginPage.class);
    }

    public  void login() throws Exception {
        waitUntilElementIsLoaded(loginButton);
        fillLoginForm(new LoginData("bpetrovski@insynctive.com", "apple$$$2405"));
        clickToLogin();
    }

    public  void clickToLogin() {
        loginButton.click();
    }

    public  void fillLoginForm(LoginData loginData) {
        loginUsernameField.sendKeys(loginData.getUserName());
        loginPasswordField.click();
        loginPasswordField.sendKeys(loginData.getPass());
    }

    public  boolean exists(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public  boolean isLoggedIn(WebElement loginButton) {
        try {
            loginButton.isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public  boolean isNotLoggedIn() {
        return driver.findElements(By.xpath("//span[@class='js-auth-signin b-navbar__exit h-ml-10']")).size() > 0;
    }

    public  void waitUntilElementIsLoaded(WebElement element) throws IOException, InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElement(WebDriverWait wait, String element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }
}
