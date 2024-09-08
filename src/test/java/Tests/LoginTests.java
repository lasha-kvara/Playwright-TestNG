package Tests;
import org.testng.annotations.Listeners;
import org.example.utils.ExtentReportListener;
import com.microsoft.playwright.Page;
import org.example.Drivers.Driver;
import org.example.base.Hooks;
import org.example.pages.LoginPage;
import org.example.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

@Listeners(ExtentReportListener.class)
public class LoginTests extends Hooks{

    private Driver _driver;
    Page page;
    String userEmail = ConfigReader.getProperty("userEmail");
    String userPassword = ConfigReader.getProperty("userPassword");
    String invalidEmail = ConfigReader.getProperty("invalidEmail");
    String invalidPassword = ConfigReader.getProperty("invalidPassword");


    @Test
    public void LoginSuccessful() {
        page = Page();
        LoginPage loginPage = new LoginPage(page);

        loginPage.ClickSignInButton();
        loginPage.EnterEmailInTheInput(userEmail);
        loginPage.EnterPasswordInTheInput(userPassword);
        loginPage.ClickSignInButton_FromLoginPage();
        Assert.assertTrue(loginPage.SuccessfulLoginMessage_isVisible());
    }

    @Test
    public void VerifyInvalidEmailMessage() {
        page = Page();
        LoginPage loginPage = new LoginPage(page);

        loginPage.ClickSignInButton();
        loginPage.EnterEmailInTheInput(invalidEmail);
        loginPage.ClickPasswordInput();
        Assert.assertTrue(loginPage.InvalidEmailInputMessage_isVisible());
    }

    @Test
    public void VerifyEmptyPasswordMessage() {
        page = Page();
        LoginPage loginPage = new LoginPage(page);

        loginPage.ClickSignInButton();
        loginPage.EnterEmailInTheInput(userEmail);
        loginPage.EnterPasswordInTheInput("");
        loginPage.ClickEmailInput();
        Assert.assertTrue(loginPage.EmptyPasswordInputMessage_isVisible());
    }

    @Test
    public void LoginWithIncorrectCredentials() {
        page = Page();
        LoginPage loginPage = new LoginPage(page);

        loginPage.ClickSignInButton();
        loginPage.EnterEmailInTheInput(invalidEmail);
        loginPage.EnterPasswordInTheInput(invalidPassword);
        loginPage.ClickSignInButton_FromLoginPage();
        Assert.assertTrue(loginPage.InvalidEmailOrPassMessage_isVisible());
    }

}
