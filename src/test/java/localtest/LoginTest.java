package localtest;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class LoginTest extends TestNgTestBase   {


    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private WebDriver driver;


    @Test
    public void loginSuccessiful() throws Exception {

    }

    @Test
    public void loginWithoutUserName() throws Exception {


    }

    @Test
    public void loginWithoutPass() throws Exception {

    }
    /**
     * Closes the WebDriver instance.
     *
     * @throws Exception thrown if an error occurs closing the WebDriver instance
     */

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
