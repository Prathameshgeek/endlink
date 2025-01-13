package endlink.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {


    WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public login(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@type='email']")
    private WebElement Email;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement Password;

    @FindBy(xpath = "//span[text()='Sign In']")
    private WebElement SigninButton;

    @FindBy(xpath = "//div[@class='src-components-molecules-account-___account-m__wrapper___2BZkt']//div//span[text()='Testing Organization']")
    private WebElement testOrg;

    @FindBy(xpath = "//div[@class='src-components-organisms-homeheader-___homeheader-m__d-flex___2Xlth']//span//span")
    private WebElement organisationTitle;

    public String titleLogin(){

        String title = driver.getTitle();
        return title;
    }



    public String login() throws InterruptedException {

        // Wait for WhatsApp Web to load completely
        wait.until(ExpectedConditions.visibilityOf(Email));
        System.out.println("Login page loaded.");

        Email.sendKeys("krithik@geekyants.com");
        Password.sendKeys("Krithi@123");
        SigninButton.click();

        Thread.sleep(3000);

        String url = driver.getCurrentUrl();
        return url;

    }

    public String selectOrg(){

        testOrg.click();
        String orgTitle = organisationTitle.getText();

        return orgTitle;
    }}








