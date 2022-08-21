package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UkrNetMailPage extends BasePage{

    @FindBy(xpath = "//p[@class='login-button__user']")
    private WebElement fieldUserEmail;

    @FindBy(xpath = "//button[@class='button primary compose']")
    private WebElement buttonWriteLetter;

    @FindBy(xpath = "//input[@name='toFieldInput']")
    private WebElement fieldWho;

    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    private WebElement iframeBodyLetter;

    @FindBy(xpath = "//body[@id='tinymce']")
    private WebElement bodyLetter;

    @FindBy(xpath = "//button[@class='button primary send']")
    private WebElement buttonSend;

    @FindBy(xpath = "//button[@class='button primary']")
    private WebElement buttonAnotherLetter;

    @FindBy(xpath = "//button[@class='login-button__control']")
    private WebElement menuAccount;

    @FindBy(xpath = "//a[@id='login__logout']/b")
    private WebElement itemMenuExit;

    @FindBy(xpath = "//a[@class='msglist__row_href']/strong")
    private WebElement shotTextLetter;

    public UkrNetMailPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFieldUserEmail(){
        return fieldUserEmail;
    }

    public String textUserEmail(){
        return fieldUserEmail.getText();
    }

    public void clickButtonWriteLetter(){
        buttonWriteLetter.click();
    }

    public void setFieldWho(String email){
        fieldWho.sendKeys(email);
    }

    public void enterTextLetter(String text){
        driver.switchTo().frame(iframeBodyLetter);
        bodyLetter.sendKeys(text);
    }

    public void clickButtonSend(){
        driver.switchTo().defaultContent();
        buttonSend.click();
    }

    public WebElement getButtonAnotherLetter(){
        return buttonAnotherLetter;
    }

    public boolean hasButtonAnotherLetter(){
        return buttonAnotherLetter.isDisplayed();
    }

    public void clickMenuAccount(){
        menuAccount.click();
    }

    public WebElement getItemMenuExit(){
        return itemMenuExit;
    }

    public void clickExit(){
        itemMenuExit.click();
    }

    public String getTextLastLetter(){
        return shotTextLetter.getText();
    }
}
