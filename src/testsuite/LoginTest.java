package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = " https://demo.nopcommerce.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find login and click on login link

        driver.findElement(By.linkText("Log in")).click();

        String expectMessage = "Welcome, Please Sign In!";

        //Find the welcome text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextMessageElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find login and click on login link
        driver.findElement(By.linkText("Log in")).click();

        // Enter valid username
        driver.findElement(By.id("Email")).sendKeys("prime123456@gmail.com");

        // Enter valid password
        driver.findElement(By.id("Password")).sendKeys("Prime123456.");

        //Click on login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

        String expectMessage = "Log out";
        //Find the text element and get the text


        WebElement actualMessageElement = driver.findElement(By.xpath("//a[@class ='ico-logout']"));
        String actualMessage = actualMessageElement.getText();

        //   Validate actual and expected message
        Assert.assertEquals("No such text passed", expectMessage, actualMessage);

    }

    @Test

    public void verifyTheErrorMessage() {
        //Find login and click on login link
        driver.findElement(By.linkText("Log in")).click();

        // Enter valid username
        driver.findElement(By.id("Email")).sendKeys("prime12345@gmail.com");

        // Enter valid password
        driver.findElement(By.id("Password")).sendKeys("Prime123456.");

        //Click on login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

        String expectMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        //Find the welcome text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualTextMessageElement.getText();

        //   Validate actual and expected message
        Assert.assertEquals("No message found", expectMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
