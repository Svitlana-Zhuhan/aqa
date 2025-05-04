package lection23_WebDriverBrowserFactoryTest;

import lection23A_WebDriverBrowserFactory_x2.GaragePage2;
import lection23A_WebDriverBrowserFactory_x2.HomePage2;
import lection23_WebDriverBrowserFactory.AddCarPopup;
import lection23_WebDriverBrowserFactory.BrowserFactory;
import lection23_WebDriverBrowserFactory.GaragePage;
import lection23_WebDriverBrowserFactory.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddCarTest extends BrowserFactory{

    private WebDriver driver;
    private HomePage homePage;
    private GaragePage garagePage;



        @Parameters("browser")
        @Test
        public void addCarTest(String browser) {
            driver = BrowserFactory.getDriver(browser);
            driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");

            homePage = new HomePage(driver);
            homePage.clickGuestLogin();

            SoftAssert softAssert = new SoftAssert();
            String currentUrl = driver.getCurrentUrl();
            softAssert.assertEquals(currentUrl, "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage", "Incorrect redirect URL");

            garagePage = new GaragePage(driver);
            garagePage.clickAddCarButton();
            garagePage.selectCarDetails("Audi", "TT", Integer.parseInt("20"));
            garagePage.clickSubmitButton();

            softAssert.assertEquals(garagePage.getCarName(), "Audi TT", "Car name not displayed correctly");
            softAssert.assertTrue(garagePage.isTodayMileageDateDisplayed(), "Current date not shown in mileage update");
            softAssert.assertEquals(garagePage.getMileageValue(), "20", "Mileage value is incorrect");
            softAssert.assertTrue(garagePage.isCarImageDisplayed(), "Car image not displayed");
            softAssert.assertTrue(garagePage.imageUrlEndsWith("audi.png"), "Image source does not end with audi.png");

            softAssert.assertAll();

            driver.quit();
        }
    }

