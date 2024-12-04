package com.safetrust.stepdefinitions;

import com.safetrust.helpers.ExcelHelper;
import com.safetrust.hooks.TestContext;
import com.safetrust.keywords.WebUI;
import com.safetrust.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsLoginSafetrust {

    LoginPage loginPage;
    ExcelHelper excelHelper;

    public StepsLoginSafetrust(TestContext testContext){
        loginPage = testContext.getLoginPage();
    }



    @And("click OK button to send request")
    public void clickOKButtonToSendRequest() {
        loginPage.clickConfirmSendResetPassword();
    }

    @Then("user should see a Request reset password notification message")
    public void userShouldSeeARequestResetPasswordNotificationMessage() {
        loginPage.verifySentRequestForgotPasswordMessage();
    }

    @And("click the login button")
    public void clickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user should see the login blocked message")
    public void userShouldSeeTheLoginBlockedMessage() {
        loginPage.verifyMessageLoginBlocked();
    }

    @When("user attempt to enter correct {string} and incorrect {string} multiple")
    public void userAttemptToEnterCorrectAndIncorrectMultiple(String email, String password) {
        loginPage.attemptToEnterCorrectAndIncorrectMultiple(email,password);
    }

//    @Given("user attempt to login with blocked account")
//    public void userAttemptToLoginWithBlockAccount() {
//        if(excelHelper == null)
//        {
//            excelHelper = new ExcelHelper();
//            excelHelper.setExcelFile("src/test/resources/datatest/Safetrust.xlsx", "Login");
//        }
//        loginPage.enterEmailAndPassword(excelHelper.getCellData("email",3), excelHelper.getCellData("password",3));
//    }

    @Given("user on the login page")
    public void userOnTheLoginPage() {
        loginPage.userOnTheLoginPage();
    }

    @Then("user should be redirected to my account dashboard")
    public void userShouldBeRedirectedToMyAccountDashboard() {
        loginPage.verifyRedirectToDashboardPage();
    }

    @When("user enter incorrect {string} and {string}")
    public void userEnterIncorrectAnd(String email, String password) {
        loginPage.enterEmailAndPassword(email,password);
    }


    @When("user enter correct Credential {string} and {string}")
    public void userEnterCorrectCredential(String email, String password) {
        loginPage.enterEmailAndPassword(email, password);
    }

    @Then("user should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String msg) {
        loginPage.userShouldSeeAnErrorMessage(msg);
    }

    @When("user enter existed {string} and abnormal {string}")
    public void userEnterExistedAndAbnormal(String email, String password) {
        loginPage.enterEmailAndPassword(email,password);
    }

    @And("click CANCEL button to cancel request")
    public void clickCANCELButtonToCancelRequest() {
        loginPage.clickCancelSendResetPassword();
    }

    @Then("Forgotten Password popup should be closed")
    public void forgottenPasswordPopupShouldBeClosed() {
        loginPage.forgottenPasswordPopupShouldBeClosed();
    }


    @When("user enter a valid {string} and open Forgotten Password popup")
    public void userEnterAValidAndOpenForgottenPasswordPopup(String email) {
        loginPage.enterEmail(email);
        loginPage.clickContinueButton();
        loginPage.openForgotPasswordPopup();
    }

    @And("stay on the login page")
    public void stayOnTheLoginPage() {

    }
}
