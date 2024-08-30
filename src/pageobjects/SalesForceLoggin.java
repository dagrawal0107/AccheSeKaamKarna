package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Sales Force Loggin"                                
     , summary=""
     , relativeUrl=""
     , connection="UIConnection"
     )             
public class SalesForceLoggin {

WebDriver driver; 

public SalesForceLoggin(WebDriver driver){
this.driver=driver;}

public void loginMethod(String Username){
driver.findElement(By.id("username")).clear();
driver.findElement(By.id("username")).sendKeys(Username);
}

@TextType()
@FindBy(xpath = "//input[@id='username']")
public WebElement username;


			
}
