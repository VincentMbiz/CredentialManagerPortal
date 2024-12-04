package com.safetrust.pages;

import com.safetrust.common.BaseTest;
import com.safetrust.drivers.DriverManager;
import com.safetrust.helpers.PropertiesHelper;
import com.safetrust.keywords.WebUI;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.safetrust.keywords.WebUI.*;


public class LoginPage
{
    private String URL = "https://demo.safetrust.com/#/login";
    public boolean isBlockedLogin = false;
    public  By welcomeDashboard = By.xpath("//p[contains(text(), 'Welcome to Safetrust')]");
    private By txtLogin = By.xpath("//h4[@class='text-left login-title-text']");
    private By inputEmail = By.xpath("//input[@id='login-username']");
    private By inputPassword = By.xpath("//input[@id='login-password']");
    private By buttonContinue = By.xpath("//button[normalize-space()='Continue']");
    private By buttonLogin = By.xpath("//button[@id='btn-login ']");
    private By buttonForgotOK = By.xpath("//button[@name='CONFIRM_OK']");
    private By buttonForgotCANCEL = By.xpath("//button[normalize-space()='Cancel']");
    private By hrefForgotPassword = By.xpath("//h4[normalize-space()='Forgotten password?']");
    private By panelLoginBlocked = By.xpath("//div[@class='background-blocked ng-scope']");
    private By dialogForgottenPassword = By.xpath("//div[@class='modal-dialog modal-lg']");
    private By messageNotice = By.xpath("//span[@data-notify='message']");// block notice, send forgot password notice, Account not found or password not match
    private By messageWrongEmailOrPassword = By.xpath("//div[@role='alert']");

    public void userOnTheLoginPage(){
        openURL(URL);
        //verify an element that belongs to Login page, is being displayed
        verifyElementVisible(txtLogin);
    }

    public void enterEmailAndPassword(String email, String password){
        setText(inputEmail,email);
        clickContinueButton();
        setText(inputPassword,password);
    }

    public void enterEmail(String email){
        setText(inputEmail,email);
    }

    public void verifyRedirectToDashboardPage(){
        verifyElementVisible(welcomeDashboard,"Can not redirect to dashboard page!");
    }
    public void verifyMessageLoginBlocked(){
        verifyElementVisible(messageNotice,"S0001651E: Login blocked","Can not see the blocked login message!");
    }
    public void verifySentRequestForgotPasswordMessage(){
        WebUI.verifyElementVisible(messageNotice,"We received your Reset Password Request and just sent you a confirmation email.","Forgot Password's notice message is not visible.");
    }
    public void clickLoginButton(){
        clickElement(buttonLogin);
        WebUI.sleep(1);
    }

    public void checkBlockedLogin(){
        isBlockedLogin = WebUI.checkElementVisible(messageNotice,"S0001651E: Login blocked");
    }
    public void attemptToEnterCorrectAndIncorrectMultiple(String email, String password){
        enterEmailAndPassword(email, password);
        int countAttempts = 5;
        while (!isBlockedLogin && countAttempts > 0){
            clickLoginButton();
            checkBlockedLogin();
            //wait until fail login message disappeared
            WebUI.sleep(3);
            countAttempts--;
        }
    }

    public void clickContinueButton(){
        clickElement(buttonContinue);
    }
    public void openForgotPasswordPopup(){
        clickElement(hrefForgotPassword);
    }
    public void clickConfirmSendResetPassword(){
        clickElement(buttonForgotOK);
    }
    public void clickCancelSendResetPassword(){
        clickElement(buttonForgotCANCEL);
    }
    public void forgottenPasswordPopupShouldBeClosed(){
        checkElementExist(dialogForgottenPassword);
    }

    public void userShouldSeeAnErrorMessage(String strMessage){
        if(messageWrongEmailOrPassword != null){
            WebUI.verifyElementVisible(messageWrongEmailOrPassword,strMessage,"Error message is not displayed");
        }
    }
}
