package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.provar.core.testapi.annotations.*;

@Page( title="Thirdparty"                                
     , summary=""
     , relativeUrl=""
     , connection="ThridUI"
     )             
public class Thirdparty {

	
	
	WebDriver driver;
	public  Thirdparty(WebDriver driver){
this.driver =driver;
}
public void AddCookies() throws InterruptedException{

driver.get("chrome://settings/cookies?search=third");
 
JavascriptExecutor js = (JavascriptExecutor)driver;

 js.executeScript("document.querySelector('body > settings-ui').shadowRoot.querySelector('#main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('#basicPage > settings-section.expanded > settings-privacy-page').shadowRoot.querySelector('#cookies > settings-cookies-page').shadowRoot.querySelector('#allowExceptionsList').shadowRoot.querySelector('#addSite').click();");
 WebElement e =(WebElement) js.executeScript("return document.querySelector('body > settings-ui').shadowRoot.querySelector('#main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('#basicPage > settings-section.expanded > settings-privacy-page').shadowRoot.querySelector('#cookies > settings-cookies-page').shadowRoot.querySelector('#allowExceptionsList').shadowRoot.querySelector('add-site-dialog').shadowRoot.querySelector('#site').shadowRoot.querySelector('#input');");
 e.sendKeys("hellokkkkkkk");
 js.executeScript("document.querySelector('body > settings-ui').shadowRoot.querySelector('#main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('#basicPage > settings-section.expanded > settings-privacy-page').shadowRoot.querySelector('#cookies > settings-cookies-page').shadowRoot.querySelector('#allowExceptionsList').shadowRoot.querySelector('add-site-dialog').shadowRoot.querySelector('#add').click();");
	}
			
}
