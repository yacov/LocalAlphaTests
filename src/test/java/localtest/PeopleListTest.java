package localtest;

/**
 * Created by Iakov Volf on 2/8/2015.
 */


import localtest.pages.LoginPage;
import localtest.pages.PeopleMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class PeopleListTest  {
    public WebDriver driver;
    public WebDriverWait wait;
    PeopleMainPage peopleMainPage;
    LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        peopleMainPage = PageFactory.initElements(driver, PeopleMainPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }


    @AfterClass(alwaysRun = true)
    public void teardown(){
        this.driver.quit();
    }


    @Test
    public void filterActivePeopleFromShortcut_9778() throws Exception {
        loginPage.login();
        peopleMainPage.clickToActiveFilter();
        peopleMainPage.checkSelectedActiveElement("Active");





    }
    //@Test
    public void testLoginFallure () throws Exception {


    }


}
