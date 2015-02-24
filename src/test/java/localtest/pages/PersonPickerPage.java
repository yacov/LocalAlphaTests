package localtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

/**
 * Created by Iakov Volf on 2/20/2015.
 */

public class PersonPickerPage extends Page {


    @FindBy(id = "processedPersonKey")
     WebElement pickProcessedPersonLink;
    @FindBy(id = "btnProcessedProcessPerson")
    WebElement pickProcessedPersonBtn;
    @FindBy(id = "btnYourselfProcessPerson")
    WebElement pickYourselfBtn;
    @FindBy(id = "PersonPickerSearchProcessPerson")
    WebElement pickerSearchInput;
    @FindBy(xpath = "//*[@id='searchResultProcessPerson']/div[1]")
    WebElement firstSearchResult;
    @FindBy(id = "popover27031")
    WebElement pickerPopUpWindow;



    public PersonPickerPage(WebDriver driver) {

       super(driver);

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        this.PAGE_URL = "http://alphaex.insynctiveapps.com/Insynctive.Components/Pickers/BasicPerson";
        this.PAGE_TITLE = "BasicPerson";
    }
public void addTextToSearch (String text) {
    pickerSearchInput.sendKeys(text);
}
    public void checkFirstSearchResult (String text){
        assertEquals(text, firstSearchResult.getText());
    }

    public void checkProceededPerson (String text){
        assertEquals(text, pickProcessedPersonLink.getText());
    }
    /*public PersonPickerPage navigateTo(WebDriver driver) {
        driver.get(PAGE_URL);
        assertEquals(PAGE_TITLE, driver.getTitle());
        return PageFactory.initElements(driver,
                PersonPickerPage.class);

    }*/

    public void clickPersonLink (){
    clickElement(pickProcessedPersonLink);
}
    public void clickPersonBtn (){
        clickElement(pickProcessedPersonBtn);
    }

    public void clickYourselfBtn (){
        clickElement(pickYourselfBtn);
    }

    public void checkText(){
        assertEquals("Test", pickProcessedPersonLink.getText());
    }

    public void checkifPickerWindowOpened(){
        verifyElementIsPresent(pickProcessedPersonBtn);
    }
}
