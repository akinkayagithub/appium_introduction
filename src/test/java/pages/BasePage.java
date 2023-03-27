package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Common elements from the header and footer and some other common elements
    @FindBy(id = "logo")
    public WebElement logo;

    @FindBy(id = "dropdown-button")
    public WebElement headerDropdown;

    @FindBy(css = "#dropdown-menu a")
    public List<WebElement> headerDropdownOptions;

    // Mobile elements
    @FindBy(css = ".navbar-brand")
    public WebElement burgerMenu;

    @FindBy(css = ".HomePage_pageTitle__UAMbk")
    public WebElement mainHeading;

    public void clickOnCard(String cardText){
        for (WebElement headerDropdownOption : headerDropdownOptions) {
            if(headerDropdownOption.getText().equals(cardText)){
                headerDropdownOption.click();
                break;
            }
        }
    }
}
