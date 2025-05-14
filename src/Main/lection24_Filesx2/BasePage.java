package lection24_Filesx2;

import lection24_Files.GaragePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    @FindBy(xpath = "//button[contains(text(), 'Guest log in')]")
    private WebElement guestLoginButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public lection24_Files.GaragePage clickGuestLogin() {
        guestLoginButton.click();
        return new GaragePage(driver);
    }
}
