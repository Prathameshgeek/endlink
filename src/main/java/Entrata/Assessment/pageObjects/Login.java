package Entrata.Assessment.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {


    WebDriver driver;

    public Login(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@type='email']")
    private WebElement Email;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement Password;

    @FindBy(xpath = "//span[text()='Sign In']")
    private WebElement SigninButton;



    public String titleLogin(){

        String title = driver.getTitle();
        return title;
    }

    public String login() throws InterruptedException {

        Email.sendKeys("krithik@geekyants.com");
        Password.sendKeys("Krithi@123");
        SigninButton.click();

        Thread.sleep(3000);

        String DashboardTitle = driver.getTitle();
        return DashboardTitle;

    }







}
