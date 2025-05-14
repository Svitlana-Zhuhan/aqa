package lection24_Filesx2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GaragePage extends BasePage {
    public GaragePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[routerlink=\"instructions\"]")
    private WebElement instructionsLink;

    public void goToInstructions() {
        instructionsLink.click();
    }
}
