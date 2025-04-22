package lection20_waitersJSExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class WaitersJSExecutorTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "https://guest:welcome2qauto@qauto.forstudy.space/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPageLoad() {
        wait.until(ExpectedConditions.titleIs("Hillel Qauto"));
        Assert.assertEquals(driver.getTitle(), "Hillel Qauto", "Title is incorrect" );
        System.out.println("Page is loaded");
    }

    @Test(dependsOnMethods = "testPageLoad")
    public void testWaitForTitle() {
        wait.until(ExpectedConditions.titleIs("Hillel Qauto"));
        Assert.assertEquals(driver.getTitle(), "Hillel Qauto", "Title is incorrect");
        System.out.println("Title is equal to " + "Hillel Qauto");
    }

    @Test(dependsOnMethods = "testWaitForTitle")
    public void testClickGuestLoginWithJS() {
        WebElement guestLoginButton = driver.findElement(By.xpath("//button[text()='Guest log in']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", guestLoginButton);
    }

    @Test(dependsOnMethods = "testClickGuestLoginWithJS")
    public void testWaitForAddCarButtonToBeClickable() {
        WebElement addCarButton = driver.findElement(By.cssSelector(".btn-primary"));
        wait.until(ExpectedConditions.elementToBeClickable(addCarButton));
        Assert.assertTrue(addCarButton.isEnabled(), "Add car button is not clickable");
        System.out.println("add car button is clickable");
    }


}
