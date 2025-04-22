package lection21_Asserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoAndButtonTestAsserts {

    private WebDriver driver;
    private final String BASE_URL = "https://guest:welcome2qauto@qauto.forstudy.space/";

    @BeforeMethod
    public void setUo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogoIsDisplayed() {
        WebElement logo = driver.findElement(By.xpath("//a[@class='header_logo']"));
        boolean isDisplayed = logo.isDisplayed();
        Assert.assertTrue(isDisplayed, "Logo does not displayed");
    }

    @Test
    public void testSignUpButtonBackgroundColor() {
        WebElement signUpButton = driver.findElement(By.cssSelector(".hero-descriptor_btn"));
        String backgroundColor = signUpButton.getCssValue("background-color");
        Assert.assertEquals(backgroundColor, "rgba(2, 117, 216, 1)", "Background color of Sign up button is incorrect");

    }
}
