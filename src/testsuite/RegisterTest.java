package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {
    String baseUrl = " https://demo.nopcommerce.com/ ";

    @Before

    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test

    public void UserShouldNavigateToRegisterPageSuccessfully(){
        //Find Register and click on Register link

        driver.findElement(By.linkText("Register")).click();

        String expectMessage = "Register";

        //Find the text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        String actualMessage = actualTextMessageElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("Not navigate to register page", expectMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // Click on Register link
        driver.findElement(By.linkText("Register")).click();

        //Select gender radio button
        driver.findElement(By.id("gender-male")).click();

        // Enter First name
        driver.findElement(By.id("FirstName")).sendKeys("Prime");

        // Enter Last name
        driver.findElement(By.id("LastName")).sendKeys("class");

        // Select Day Month and Year
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("1");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("April");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1990");


        // Enter Email address
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.click();
        Random randomGenerator = new Random();// random generator class
        int randomInt = randomGenerator.nextInt(1000);
        emailField.sendKeys("username"+ randomInt +"@gmail.com");// creating random email generator


        // Enter Password
        driver.findElement(By.id("Password")).sendKeys("Prime123456.");


        // Enter Confirm password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Prime123456.");



        // Click on REGISTER button
        driver.findElement(By.name("register-button")).click();


        String expectMessage = "Your registration completed";

        //Find the text element and get the text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[@class = 'result']"));
        String actualMessage = actualTextMessageElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("Registration message not displayed", expectMessage, actualMessage);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}


