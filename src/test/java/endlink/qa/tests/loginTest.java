package endlink.qa.tests;

import endlink.qa.core.BaseClass;
import endlink.qa.pageObjects.login;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTest extends BaseClass {


    @Test(priority = 0, groups = {"smoke", "regression"})
    public void loginTest() throws InterruptedException {

        login lgn = new login(driver);

        String title1 = lgn.titleLogin();
        Assert.assertEquals(title1, "endlink"); // Validate the page title upon navigation to the new page.

        String url = lgn.login();
        Assert.assertEquals(url, "https://qa.endlink.dev/all"); //Validate the page url upon navigation to the new page.

        String organizationtitle = lgn.selectOrg();
        Assert.assertEquals(organizationtitle, "Testing Organization"); //Validate the page url upon navigation to the new page.

    }
}
