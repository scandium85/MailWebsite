package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UkrNetLoginPage extends BasePage{

    @FindBy(xpath ="//input[@name='login']")
    private WebElement fieldLogin;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkboxShotSession;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    private WebElement iframeCaptcha;

    @FindBy(xpath = "//span[@id='recaptcha-anchor']")
    private WebElement checkboxRecaptcha;

    @FindBy(xpath = "//iframe[@name='mail widget']")
    private WebElement iframeMail;

    @FindBy(xpath = "//p[@class='login-button__user']")
    private WebElement fieldUserEmail;

    @FindBy(xpath = "//p[contains(@class,'emptyBoth')]")
    private WebElement msgEmptyBothField;

    @FindBy(xpath = "//p[contains(@class,'emptyLogin')]")
    private WebElement msgEmptyLogin;

    @FindBy(xpath = "//p[contains(@class,'emptyPassword')]")
    private WebElement msgEmptyPassword;

    @FindBy(xpath = "//p[@class='_1oZFLSZ_']")
    private WebElement msgIncorrectData;

    public UkrNetLoginPage(WebDriver driver) {
        super(driver);
    }

    public void setFieldLogin(String login){
        fieldLogin.sendKeys(login);
    }

    public void setFieldPassword(String password){
        fieldPassword.sendKeys(password);
    }

    public void activateShotSession(){
        checkboxShotSession.click();
    }

    public boolean disabledButtonSubmit(){
        return buttonSubmit.isDisplayed();
    }

    public void clickSubmit(){
        buttonSubmit.click();
    }

    public WebElement getIframeCaptcha(){
        return iframeCaptcha;
    }

    public WebElement getCheckboxRecaptcha(){
        driver.switchTo().frame(iframeCaptcha);
        return checkboxRecaptcha;
    }

    public void clickRecaptcha(){
        checkboxRecaptcha.click();
    }

    public WebElement getMsgIncorrectData(){
        driver.switchTo().defaultContent();
        return msgIncorrectData;
    }

    public String textWrong(){
        return msgIncorrectData.getText();
    }
}
