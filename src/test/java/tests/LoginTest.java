package tests;

import pages.LoginPage;
import utils.webUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setup() {
        driver = webUtils.getWebDriver();
        loginPage = new LoginPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    void testValidLogin(String loginEmail, String loginPassword) {
        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLogin_Button();
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#invalidLoginData")
    void testInvalidLogin(String loginEmail, String loginPassword) {
        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLogin_Button();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}