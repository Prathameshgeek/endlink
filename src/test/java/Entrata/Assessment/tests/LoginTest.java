package Entrata.Assessment.tests;

import Entrata.Assessment.core.BaseClass;
import Entrata.Assessment.pageObjects.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Entrata.Assessment.core.BaseClass.driver;

public class LoginTest extends BaseClass {


    @Test(groups= {"SmokeTest"})
    public void loginTest() throws InterruptedException {

        Login lgn = new Login(driver);

        String title1 = lgn.titleLogin();
        Assert.assertEquals(title1, "endlink"); // Validate the page title upon navigation to the new page.

        String title2 = lgn.login();
        Assert.assertEquals(title2, "endlink"); //Validate the page title upon navigation to the new page.
}}
