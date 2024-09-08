package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.example.Drivers.Driver;
import org.example.base.Hooks;
import org.example.utils.ConfigReader;
import org.testng.annotations.Test;


public class LoginPage {
    private Page page;

    public LoginPage(Page page){
        this.page = page;
    }

    public void ClickSignInButton(){
        _signInButton().click();
    }
    public void EnterEmailInTheInput(String email){
        _emailInput().fill(email.toLowerCase());
    }
    public void EnterPasswordInTheInput(String pass){
        _passwordInput().fill(pass);
    }
    public void ClickPasswordInput(){
        _passwordInput().click();
    }
    public void ClickEmailInput(){
        _emailInput().click();
    }
    public void ClickSignInButton_FromLoginPage(){
        _signInButtonInLoginPage().click();
    }

    public boolean InvalidEmailOrPassMessage_isVisible(){
        Locator invalidEmailOrPasswordMessage = _invalidEmailOrPasswordMessage();
        invalidEmailOrPasswordMessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return _invalidEmailOrPasswordMessage().isVisible();
    }

    public boolean InvalidEmailInputMessage_isVisible() {
        Locator invalidEmailInputMessage = _invalidEmailInputMessage();
        invalidEmailInputMessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return _invalidEmailInputMessage().isVisible();
    }

    public boolean EmptyPasswordInputMessage_isVisible() {
        Locator emptyPasswordInputMessage = _emptyPasswordInputMessage();
        emptyPasswordInputMessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return _emptyPasswordInputMessage().isVisible();
    }

    public boolean SuccessfulLoginMessage_isVisible() {
        Locator successMessage = _successfulLoginMessage();
        successMessage.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return _successfulLoginMessage().isVisible();
    }









    //Locators for Login Page
    private Locator _signInButton() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In"));
    }
    private Locator _emailInput() {
        return page.getByPlaceholder("Email");
    }
    private Locator _passwordInput() {
        return page.getByPlaceholder("Password");
    }
    private Locator _signInButtonInLoginPage() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in"));
    }

    private Locator _invalidEmailOrPasswordMessage() {
        return page.locator("#notice").getByText("Invalid email or password.");
    }
    private Locator _invalidEmailInputMessage() {
        return page.getByText("Please enter a valid email");
    }
    private Locator _emptyPasswordInputMessage() {
        return page.getByText("This field cannot be blank");
    }

    private Locator _successfulLoginMessage() {
        return page.getByText("Signed in successfully.");
    }







}
