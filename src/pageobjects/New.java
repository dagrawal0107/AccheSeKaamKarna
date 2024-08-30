package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="New"                                
     , summary=""
     , relativeUrl=""
     , connection="DevOrg"
     )             
public class New {

	@TextType()
	@FindBy(xpath = "//div[contains(@class, 'active') and contains(@class, 'open') and (contains(@class, 'forceModal') or contains(@class, 'uiModal'))][last()]//input[@id='input-170']")
	public WebElement Phone;
	@LinkType()
	@FindBy(xpath = "//one-app-nav-bar-menu-item/a[normalize-space(.)='Opportunities']")
	public WebElement opportunities;
	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Accounts']")
	public WebElement accounts;
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//button[@name='NewContact']")
	public WebElement NewContact;
	@ButtonType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//button[normalize-space(.)='Show more actions']")
	public WebElement showMoreActions;
	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[@name='Edit']")
	public WebElement Edit;
			
}
