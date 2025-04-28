package lection22_Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TitleAndSocialNetworkTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String[] expectedUrls = {
            "https://www.facebook.com/Hillel.IT.School",
            "https://t.me/ithillel_kyiv",
            "https://www.youtube.com/user/HillelITSchool",
            "https://www.instagram.com/hillel_itschool/",
            "https://www.linkedin.com/school/ithillel/"
    };

   @BeforeMethod
    public void setUo() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/" );
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testTitleIsDisplayed() {
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String frameTitle = (String) js.executeScript("return document.title");
        Assert.assertEquals(frameTitle, "Hillel IT School | Учись ради мечты! - YouTube", "Title doesn’t equals to the expected result");

    }

    @Test
    public void testFrameTitleIsDisplayed() {
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String frameTitle = (String) js.executeScript("return document.title");
        Assert.assertEquals(frameTitle, "Як потрапити у майбутнє? Трансформація навчання. - YouTube", "Title doesn’t equals to the expected result");

    }

    @Test
    public void testSocialNetworksBlock() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        List<WebElement> socialIcons = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".socials_icon.icon"), 4));

        Assert.assertEquals(socialIcons.size(), 5, "Social network block doesn't contain 5 items");

        List<String> expectedUrls = List.of(
                "https://www.facebook.com/",
                "https://t.me/",
                "https://www.youtube.com/",
                "https://www.instagram.com/",
                "https://www.linkedin.com/"
        );

        String originalWindow = driver.getWindowHandle();

        for (int i = 0; i < socialIcons.size(); i++) {
            WebElement icon = socialIcons.get(i);
            js.executeScript("arguments[0].scrollIntoView(true);", icon);
            icon.click();

            wait.until(driver -> driver.getWindowHandles().size() > 1);

            Set<String> allWindows = driver.getWindowHandles();
            List<String> windowsList = new ArrayList<>(allWindows);

            String newTabHandle = "";
            for (String handle : windowsList) {
                if (!handle.equals(originalWindow)) {
                    newTabHandle = handle;
                    break;
                }
            }

            if (newTabHandle.isEmpty()) {
                throw new AssertionError("New tab did not open after clicking");
            }

            driver.switchTo().window(newTabHandle);

            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
            boolean isCorrect = expectedUrls.stream().anyMatch(currentUrl::startsWith);
            Assert.assertTrue(isCorrect, "Incorrect url of Social network: " + currentUrl);

            driver.close();
            driver.switchTo().window(originalWindow);
        }
    }
}
