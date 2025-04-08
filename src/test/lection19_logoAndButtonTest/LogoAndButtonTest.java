package lection19_logoAndButtonTest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogoAndButtonTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1, description = "Logo displayed test")
    public void testLogoDisplayed() {
        try {
            WebElement logo = driver.findElement(By.xpath("//a[@class='header_logo']"));
            if (logo.isDisplayed()) {
                System.out.println("Logo displayed");
                Assert.assertTrue(true, "Logo displayed");
            } else {
                System.out.println("Logo does not displayed");
                Assert.fail("Logo does not displayed");
            }
        } catch (Exception e) {
            System.out.println("Logo element is not found: " + e.getMessage());
            Assert.fail("Logo element is not found");
        }
    }

    @Test(priority = 2, description = "Background color of Sign up button test")
    public void signUpButtonColor() {
        try {
            WebElement signUpButton = driver.findElement(By.cssSelector(".hero-descriptor_btn"));
            String backgroundColor = signUpButton.getCssValue("background-color");
            String expectedColor = "rgba(2, 117, 216, 1)";

            if (backgroundColor.equals(expectedColor)) {
                System.out.println("Background color of Sign up button is correct.");
                Assert.assertTrue(true, "Background color of Sign up button is correct");
            } else {
                System.out.println("Background color of Sign up button is incorrect.");
                Assert.assertEquals(backgroundColor, expectedColor, "Background color of Sign up button is incorrect");
            }
        } catch (Exception e) {
            System.out.println("Sign up button element is not found: " + e.getMessage());
            Assert.fail("Sign up button element is not found");
        }
    }
}

