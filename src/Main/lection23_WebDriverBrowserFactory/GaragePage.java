package lection23_WebDriverBrowserFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GaragePage {

    private final WebDriver driver;
    private WebDriverWait wait;

    private final By addCarButton = By.xpath("//button[@class='btn btn-primary' and contains(text(), 'Add car')]");
    // @FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(), 'Add car')]")
    // private WebElement addCarButton;

    private final By addCarBrand = By.id("addCarBrand");
    //@FindBy(id = "addCarBrand")
    //private WebElement addCarBrand;

    private final By addCarModel = By.id("addCarModel");
    // @FindBy(id = "addCarModel")
    // private WebElement addCarModel;

    private final By mileageUpdateParagraph = By.cssSelector("p.car_update-mileage");
    //@FindBy(css = "p.car_update-mileage")
    //private WebElement mileageUpdateParagraph;

    private final By mileageInput = By.id("addCarMileage");
    // @FindBy(id = "addCarMileage")
    //private WebElement mileageInput;

    private final By carLogoImage = By.cssSelector(".car-logo_img");
//    @FindBy(css = ".car-logo_img")
//    private WebElement carLogoImage;

    private final By carTitle = By.cssSelector(".car_name.h2");
//    @FindBy(css = ".car_name.h2")
//    private WebElement carTitle;

    private final By updateMileageInput = By.cssSelector(".update-mileage-form_input.form-control");

    // private String brandDropdownXpath = "//option[normalize-space(text())='Audi']";
    // private final By brandDropdown = By.xpath("//option[normalize-space(text())='Audi']");
//    @FindBy(xpath = "//option[normalize-space(text())='Audi']")
//    private WebElement brandDropdown;
    private String dropdownOptionXpath = "//option";

    // private String modelDropdownXpath = "//option[normalize-space(text())='TT']";
//    @FindBy(xpath = "//option[normalize-space(text())='TT']")
//    private WebElement modelDropdown;

    private final By addButton = By.xpath("//button[contains(@class, 'btn-primary') and normalize-space(text())='Add']");
//    @FindBy(xpath = "//button[contains(@class, 'btn-primary') and normalize-space(text())='Add']")
//    private WebElement addButton;

    public GaragePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickAddCarButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addCarButton)).click();
    }

    public void selectCarDetails(String brand, String model, int mileage) {
        wait.until(ExpectedConditions.elementToBeClickable(addCarBrand)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(dropdownOptionXpath, brand)))).click();

        wait.until(ExpectedConditions.elementToBeClickable(addCarModel)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(dropdownOptionXpath, model)))).click();

        WebElement mileageField = wait.until(ExpectedConditions.visibilityOfElementLocated(mileageInput));
        mileageField.clear();
        mileageField.sendKeys(String.valueOf(mileage));
    }

    public void clickSubmitButton() {
        driver.findElement(addButton).click();
        // wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public String getCarName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(carTitle)).getText();
    }

    public boolean isTodayMileageDateDisplayed() {
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String text = driver.findElement(mileageUpdateParagraph).getText();
        return  text.contains(expectedDate);
    }

    public String getMileageValue() {
        return driver.findElement(updateMileageInput).getAttribute("value");
    }

    public boolean isCarImageDisplayed() {
        return  driver.findElement(carLogoImage).isDisplayed();
    }

    public boolean imageUrlEndsWith(String suffix) {
        String src = driver.findElement(carLogoImage).getAttribute("src");
        return src.endsWith(suffix);
    }
}