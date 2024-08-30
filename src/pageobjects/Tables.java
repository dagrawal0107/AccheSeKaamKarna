package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.model.ui.api.UiFacet;
import com.provar.core.testapi.annotations.*;

@Page( title="Tables"                                
     , summary=""
     , relativeUrl=""
     , connection="NewUI"
     )             
public class Tables {

@PageRow()
    public static class Example {

        @TextType()
        @FindBy(xpath = "//td[1]")  //table column
        public WebElement Company;
    }

    
    @FacetFindBys(value = {
            @FacetFindBy(findBy = @FindBy(xpath = "tbody/tr"), facet = UiFacet.DATA_ROWS),  //datarow
            @FacetFindBy(findBy = @FindBy(xpath = "tbody/tr[1]"), facet = UiFacet.HEADER_ROW) }) //headerrow
    @FindBy(xpath = "(//table[@id='customers'])[1]")  //table xpath
    @PageTable(firstRowContainsHeaders = false, row = Example.class)
    public List<Example> example;
			
}
