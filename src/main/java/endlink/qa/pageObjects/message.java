package endlink.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class message {

    WebDriver driver;

    public message(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='New sub']")
    private WebElement selectUser;

    @FindBy(xpath = "//div[@class='src-components-organisms-chatheader-___chatheader-m__headingbar___3OEmM']//div//span")
    private WebElement subject;

    @FindBy(xpath = "//textarea[@placeholder='Secure Message']")
    private WebElement textField;

    @FindBy(xpath = "(//div[@class='src-components-organisms-swipeToLeft-___swipeToLeft-m__swipeItem-content___2TRh0'])[1]//span//span")
    private WebElement lastMes;

    @FindBy(xpath = "(//div[@class='src-components-organisms-detailedMessage-___detailedmessage-m__messagestatus___scpR-'])[1]//span//span")
    private WebElement textStatus;

    @FindBy(className = "sendbutton")
    private WebElement sendButton;

    @FindBy(xpath = "(//div[@class='src-components-organisms-detailedMessage-___detailedmessage-m__messagestatus___scpR-'])[1])")
    private WebElement lastMessageStatus;



    public String selectUser(){

        selectUser.click();
        String sub =   subject.getText();
        return sub;
    }

    public String sendMessageAndVerify(String message){

        textField.sendKeys(message);
        String lastMessage = lastMes.getText();

        sendButton.click();

        return lastMessage ;
    }

    public boolean verifyStatus() throws InterruptedException {

        String status = textStatus.getText();
        boolean messageStatus = false;

        if (status.equals("Delivered") || status.equals("Read")) {
            messageStatus = true;
        }
        else {
            driver.navigate().refresh();
            WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(textStatus));
        }

        return messageStatus;

    }





}
