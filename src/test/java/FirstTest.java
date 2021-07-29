import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test(description = "Verify if user won`t be  loged in with incorrect password")
    public void verifyUserEnteredInvalidPasswordException(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");//""C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#!/Home?lang=en");

        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();

        WebElement mailInput = driver.findElement(By.id("username"));
        mailInput.sendKeys("mnadiyaka@gmail.com");

        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("qwerty12345");

        WebElement signInPasswordButton = driver.findElement(By.id("kc-login"));
        signInPasswordButton.click();

        WebElement excIncorrectCred = driver.findElement(By.className("error-text"));
        Assert.assertEquals(excIncorrectCred.getText(), "We can't find user with such credentials");

        driver.quit();
    }
}
