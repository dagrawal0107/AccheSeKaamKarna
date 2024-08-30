package customapis;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;
@TestApi( title="Day Calculator"
        , summary=""
        , remarks=""
        , iconBase=""
        , defaultApiGroups={"Custom"}
        )
@TestApiParameterGroups(parameterGroups={
	    @TestApiParameterGroup(groupName="inputs", title="Inputs"),
	    @TestApiParameterGroup(groupName="result", title="Result"),
	    })
public class DayCalculator {
    @TestApiParameter(seq=1,
            summary="The first parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String param1;
    @TestApiParameter(seq=2,
            summary="The second parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String param2;
    @TestApiParameter(seq=10,
            summary="The name that the result will be stored under.",
            remarks="",
            mandatory=true,
            parameterGroup="result")
    public String resultName;
    @TestApiParameter(seq=11,
            summary="The lifespan of the result.",
            remarks="",
            mandatory=true,
            parameterGroup="result",
            defaultValue="Test")
    public ValueScope resultScope;
    /**
     * Used to write to the test execution log.
     */
    @TestLogger
    public Logger testLogger;
    /**
     * Provides access to facilities, mainly to set and get variable values.
     */
    @TestExecutionContext
    public ITestExecutionContext testExecutionContext;
    @TestApiExecutor
    public void execute() {
    	// Put our implementation logic here.
    	testLogger.info("Hello from " + this.getClass().getName());
    	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    	Date date1=null;
    	Date date2=null;
    	try {
    	date1 = sdf.parse(param1); // Current date and time
         date2 = sdf.parse(param2); // Current date + 10 seconds
    	}
    	catch(Exception e) {
    		
    	}
    	String dummyResult = this.getClass().getName() + " result";
         // Compare the two dates
         if (date1.before(date2)) {
             dummyResult="date1 is before than date2";
         } else if (date1.after(date2)) {
             dummyResult="date1 is greater (later) than date2";
         } else {
             dummyResult="date1 and date2 are equal";
         }
        // Store the result (if appropriate).
    	
        testExecutionContext.setValue(resultName, dummyResult, resultScope);
    }
}