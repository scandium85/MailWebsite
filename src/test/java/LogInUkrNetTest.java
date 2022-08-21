import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogInUkrNetTest extends BaseTest {
    private final String LOGIN1 = "krasavskiym";
    private final String PASSWORD1 = "5XA!FF8-Z46gw6a";
    private final String LOGIN2 = "krasavskiynick";
    private final String PASSWORD2 = "nwjMmKDV2@5FLqu";
    private final String TEXT = "Hi!";
    private final String MSG = "Неправильні дані";

    @Test(priority = 1)
    public void positiveLogin(){
        getUkrNetHomePage().setFieldLogin(LOGIN1);
        getUkrNetHomePage().setFieldPassword(PASSWORD1);
        getUkrNetHomePage().activateShotSession();
        getUkrNetHomePage().clickSubmit();
        getUkrNetHomePage().waitVisibilityOfElement(Duration.ofSeconds(30),getUkrNetMailPage().getFieldUserEmail());

        Assert.assertEquals(getUkrNetMailPage().textUserEmail(), LOGIN1 + "@ukr.net");
        getUkrNetMailPage().clickButtonWriteLetter();
        getUkrNetMailPage().setFieldWho(LOGIN2 + "@ukr.net");
        getUkrNetMailPage().enterTextLetter(TEXT);
        getUkrNetMailPage().clickButtonSend();
        getUkrNetMailPage().waitVisibilityOfElement(Duration.ofSeconds(30), getUkrNetMailPage().getButtonAnotherLetter());
        Assert.assertTrue(getUkrNetMailPage().hasButtonAnotherLetter());

        getUkrNetMailPage().clickMenuAccount();
        getUkrNetMailPage().waitVisibilityOfElement(Duration.ofSeconds(30), getUkrNetMailPage().getItemMenuExit());
        getUkrNetMailPage().clickExit();
        getUkrNetHomePage().setFieldLogin(LOGIN2);
        getUkrNetHomePage().setFieldPassword(PASSWORD2);
        getUkrNetHomePage().activateShotSession();
        getUkrNetHomePage().clickSubmit();
        getUkrNetHomePage().waitVisibilityOfElement(Duration.ofSeconds(30),getUkrNetMailPage().getFieldUserEmail());

        Assert.assertEquals(getUkrNetMailPage().textUserEmail(), LOGIN2 + "@ukr.net");
        Assert.assertEquals(getUkrNetMailPage().getTextLastLetter(), " " + TEXT);
    }

    @Test(priority = 2)
    public void emptyLoginAndPassword(){
        Assert.assertTrue(getUkrNetHomePage().disabledButtonSubmit());
    }

    @Test(priority = 2)
    public void emptyLogin(){
        getUkrNetHomePage().setFieldPassword(PASSWORD1);
        getUkrNetHomePage().clickSubmit();
        Assert.assertTrue(getUkrNetHomePage().disabledButtonSubmit());
    }

    @Test(priority = 2)
    public void emptyPassword(){
        getUkrNetHomePage().setFieldLogin(LOGIN1);
        getUkrNetHomePage().clickSubmit();
        Assert.assertTrue(getUkrNetHomePage().disabledButtonSubmit());
    }

    @Test(priority = 2)
    public void negativeLogin() {
        getUkrNetHomePage().setFieldLogin(LOGIN1);
        getUkrNetHomePage().setFieldPassword("122");
        getUkrNetHomePage().clickSubmit();
        getUkrNetHomePage().waitVisibilityOfElement(Duration.ofSeconds(10), getUkrNetHomePage().getIframeCaptcha());
        getUkrNetHomePage().waitVisibilityOfElement(Duration.ofSeconds(10), getUkrNetHomePage().getCheckboxRecaptcha());
        getUkrNetHomePage().clickRecaptcha();
        getUkrNetHomePage().waitTextToBeElement(Duration.ofSeconds(20), getUkrNetHomePage().getMsgIncorrectData(), MSG);
        Assert.assertEquals(getUkrNetHomePage().textWrong(), MSG);
    }
}
