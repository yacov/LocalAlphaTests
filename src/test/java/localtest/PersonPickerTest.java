package localtest;

/**
 * Created by Iakov Volf on 2/8/2015.
 */


import localtest.pages.PersonPickerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class PersonPickerTest  {
    public WebDriver driver;
    public WebDriverWait wait;
 PersonPickerPage personpickerpage;


    @BeforeClass(alwaysRun = true)
    public void setup(){
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        personpickerpage = PageFactory.initElements(driver, PersonPickerPage.class);
    }


    @AfterClass(alwaysRun = true)
    public void teardown(){
        this.driver.quit();
    }

    @Test
    public void checkIfPopUpOpen() throws Exception {
        personpickerpage.loadPage();
        personpickerpage.clickPersonLink();
        personpickerpage.checkifPickerWindowOpened();
    }

  @Test
    public void pickProcessedPersonTest() throws Exception {
        personpickerpage.loadPage();
        personpickerpage.clickPersonLink();
        personpickerpage.clickPersonBtn();
        personpickerpage.checkProceededPerson("Processed Person");
    }

    @Test
    public void pickYourselfTest() throws Exception {
        personpickerpage.loadPage();
        personpickerpage.clickPersonLink();
        personpickerpage.clickYourselfBtn();
        personpickerpage.checkProceededPerson("Test");
    }

    @Test
    public void SearchTest() throws Exception {
        personpickerpage.loadPage();
        personpickerpage.clickPersonLink();
        personpickerpage.addTextToSearch("mary po");
        personpickerpage.checkFirstSearchResult("MP Mary Po");

    }



}
