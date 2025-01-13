package endlink.qa.tests;

import endlink.qa.core.BaseClass;
import endlink.qa.pageObjects.addCoworker;
import endlink.qa.pageObjects.login;
import org.testng.Assert;
import org.testng.annotations.Test;

import static endlink.qa.core.BaseClass.driver;

public class addCoworkerTest extends BaseClass {


    @Test(priority = 2, groups = {"regression"} )
    public void redirectTest() {

        addCoworker coworker = new addCoworker(driver);

        Assert.assertEquals(coworker.directToCommunityManagement() , "Coworker Management");

    }
}