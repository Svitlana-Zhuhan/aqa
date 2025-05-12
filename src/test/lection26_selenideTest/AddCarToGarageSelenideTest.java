package lection26_selenideTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import lection26_selenide.AddCarPopup;
import lection26_selenide.GaragePage;
import lection26_selenide.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class AddCarToGarageSelenideTest {

    private final String BASE_URL = "https://guest:welcome2qauto@qauto.forstudy.space/";
    private final String EXPECTED_GARAGE_URL = "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage";
    private final String CAR_BRAND = "Audi";
    private final String CAR_MODEL = "TT";
    private final String CAR_MILEAGE = "20";

    private HomePage homePage;
    private GaragePage garagePage;
    private AddCarPopup addCarPopup;

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        open(BASE_URL);
        homePage = page(HomePage.class);
    }

    @Test
    public void testAddCarToGarageAsGuest() {
        garagePage = homePage.clickGuestLogin();

        webdriver().shouldHave(url(EXPECTED_GARAGE_URL));

        addCarPopup = garagePage.clickAddCarButton();
        addCarPopup.selectBrand(CAR_BRAND);
        addCarPopup.selectModel(CAR_MODEL);
        addCarPopup.enterMileage(CAR_MILEAGE);
        garagePage = addCarPopup.clickAddButton();


        garagePage.addedCarTitle.shouldBe(Condition.visible).shouldHave(Condition.text(CAR_BRAND + " " + CAR_MODEL));

        String expectedDate = "Update mileage •  " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        garagePage.mileageUpdateParagraph.shouldBe(Condition.visible).shouldHave(Condition.text(expectedDate));

        garagePage.mileageInput.shouldBe(Condition.visible).shouldHave(Condition.value(CAR_MILEAGE));

        garagePage.carLogoImage.shouldBe(Condition.visible);
        garagePage.carLogoImage.shouldHave(Condition.attributeMatching("src", ".*audi\\.png$"));
    }
}
