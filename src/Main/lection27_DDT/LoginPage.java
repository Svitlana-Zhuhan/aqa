package lection27_DDT;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement signInButton = $(".btn.header_signin");
    private final SelenideElement emailInput = $("#signinEmail");
    private final SelenideElement passwordInput = $("#signinPassword");
    private final SelenideElement loginButton = $(By.xpath("//button[contains(text(), 'Login')]"));
    private final SelenideElement errorMessage = $(".alert-danger");

    public void clickSignInButton() {
        signInButton.click();
    }

    public void enterEmail(String email) {
        emailInput.setValue(email);
    }

    public void enterPassword(String password) {
        passwordInput.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

   public void verifyErrorMessage() {
    errorMessage.shouldBe(visible).shouldHave(text("Wrong email or password"));
    }
}
