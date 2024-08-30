package pageobjects.P2;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.model.ui.api.UiFacet;
import com.provar.core.testapi.annotations.*;

@Page( title="Empty"                                
     , summary=""
     , relativeUrl="C:\\Users\\deepak.agrawal\\Provar\\Workspace1\\Traning1\\src\\pageobjects\\P1"
     , connection="DevOrg"
     )             
public class Empty {
public static class Example {
	@TextType()
	@FindBy(xpath = "//td[normalize-space(.)='Alfreds Futterkiste']")
	public WebElement Name;
			
}

@FindBy(xpath="//td[normalize-space(.)='Alfreds Futterkiste']")
//@PageTable(firstRowContainsHeaders = false , row = Example.class)
public List<Example> list;

}
