package endlink.qa.tests;

import endlink.qa.core.BaseClass;
import endlink.qa.pageObjects.message;
import org.testng.Assert;
import org.testng.annotations.Test;

import static endlink.qa.core.BaseClass.driver;

public class MessageTest extends BaseClass {


    @Test(priority = 1, groups = {"smoke", "regression"} )
    public void sendMessage() throws InterruptedException {

        message mes = new message(driver);

        String userSub = mes.selectUser();
        Assert.assertEquals(userSub, "New Sub");

        String message = "Hello! This is a test message.";
       String lastMessage = mes.sendMessageAndVerify(message);

        Assert.assertEquals(lastMessage, message);

        Assert.assertTrue(mes.verifyStatus());
    }
}
