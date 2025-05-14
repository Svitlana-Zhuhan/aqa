package lection27_DDTtest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lection27_DDT.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class LoginWithInvalidDataTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        Selenide.open("https://guest:welcome2qauto@qauto.forstudy.space/");
        Configuration.browser = "Chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        loginPage = page(LoginPage.class);
        loginPage.clickSignInButton();
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"test@hillel.ua", "1111"},
                {"test@hillel.ua", "1234"}
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void testLoginWithInvalidCredentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        loginPage.verifyErrorMessage();
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
