package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(name = "email")
    private WebElement usernameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        final String url = "https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html";
        System.out.println("navigate to " + url);
        this.driver.get(url);
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
    }

    private void sendKeys(WebElement element, String key) {
        element.sendKeys(key);
        System.out.println("send " + key + " to " + element.toString());
    }

    public void enterUserDetails(String firstName, String lastName){
        sendKeys(this.firstNameTxt, firstName);
        sendKeys(this.lastNameTxt, lastName);
    }

    public void enterUserCredentials(String username, String password){
        sendKeys(this.usernameTxt, username);
        sendKeys(this.passwordTxt, password);
        sendKeys(this.confirmPasswordTxt, password);
    }

    public void submit(){
        this.submitBtn.click();
    }

}
