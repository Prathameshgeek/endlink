package endlink.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class addCoworker {

    WebDriver driver;

    public addCoworker(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='src-components-organisms-homeheader-___homeheader-m__upperheader___11Nuz']//img")
    private WebElement menu;

    @FindBy(xpath = "(//div[@class='src-components-molecules-menuoptions-___menuoptions-m__wrapper___1mwyP']//span//span)[3]")
    private WebElement communityManagement;

    @FindBy(xpath = "//div[@class='src-components-organisms-menuheader-___menuheader-m__wrapper___ZEqun']//div//span//span")
    private WebElement headline;

    @FindBy(xpath = "(//div[@class='src-components-organisms-communityManagement-___communityManagement-m__row___3Rh2Q']//span)[1]")
    private WebElement coworkerOption;

    @FindBy(css = ".plusicon")
    private WebElement plusaIcon;


    public String directToCommunityManagement(){

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(menu));

        menu.click();
        communityManagement.click();
        coworkerOption.click();

        String title = headline.getText();
        plusaIcon.click();

        return title;

    }


}
