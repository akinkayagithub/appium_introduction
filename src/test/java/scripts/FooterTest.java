package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends Base{
    @Test(priority = 1, description = "Validate Facebook button")
    public void validateFacebookButton(){
        basePage.facebookButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
    }
}
