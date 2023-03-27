package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends Base{

    @Test(priority = 1, description = "Validate TechGlobal logo is displayed")
    public void validateLogoIsDisplayed(){
        Assert.assertTrue(basePage.logo.isDisplayed());
    }

    @Test(priority = 2, description = "Validate Header practices dropdown with its options")
    public void validatePracticesDropdown(){
        Assert.assertEquals(basePage.headerDropdown.getText(), "Practices");
        basePage.headerDropdown.click();

        String[] expectedDropdownOptions = {"Frontend Testing", "Backend Testing", "Java Exercises", "Mock Interviews"};
        
        for (int i = 0; i < basePage.headerDropdownOptions.size(); i++) {
            Assert.assertEquals(basePage.headerDropdownOptions.get(i).getText(), expectedDropdownOptions[i]);
        }
    }

}
