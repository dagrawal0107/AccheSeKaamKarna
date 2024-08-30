package pageobjects;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Testing 1"                                
     , summary=""
     , relativeUrl=""
     , connection="DevOrg"
     )             
public class Testing1 {

WebDriver driver;

public Testing1(WebDriver driver){
this.driver=driver;
}

@TextType
@FindBy(xpath = "is=2")
public WebElement Helklo;

public void Hello1(){

Helklo.click();

}
			
}
