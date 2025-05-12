package lection26_selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    private SelenideElement guestLoginButton = $("button.header-link.-guest");

    public GaragePage clickGuestLogin() {
        guestLoginButton.click();
        return page(GaragePage.class);
    }
}
