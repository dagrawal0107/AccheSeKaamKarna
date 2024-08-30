package customapis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.TestApi;
import com.provar.core.testapi.annotations.TestApiExecutor;
import com.provar.core.testapi.annotations.TestApiParameter;
import com.provar.core.testapi.annotations.TestApiParameterGroup;
import com.provar.core.testapi.annotations.TestApiParameterGroups;
import com.provar.core.testapi.annotations.TestExecutionContext;
import com.provar.core.testapi.annotations.TestLogger;

@TestApi(title = "Read Word File", summary = "", remarks = "", iconBase = "", defaultApiGroups = { "Custom" })
@TestApiParameterGroups(parameterGroups = { @TestApiParameterGroup(groupName = "inputs", title = "Inputs"),
		@TestApiParameterGroup(groupName = "result", title = "Result"), })
public class ReadWordFile {

	@TestApiParameter(seq = 1, summary = "The file path which you want to read", remarks = "", mandatory = true, parameterGroup = "inputs")
	public String filePath;

	@TestApiParameter(seq = 2, summary = "The name that the result will be stored under.", remarks = "", mandatory = true, parameterGroup = "result")
	public String resultName;

	@TestApiParameter(seq = 3, summary = "The lifespan of the result.", remarks = "", mandatory = true, parameterGroup = "result", defaultValue = "Test")
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

	public String readWordFile() throws IOException {
		try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(filePath)))) {

			String res = new XWPFWordExtractor(doc).getText();
			return res;
		}
	}

	@TestApiExecutor
	public void readEveryWord() throws IOException {
		String[] resultArray = readWordFile().split("\\s+");
		List<String> resultList = new ArrayList<String>();
		for (String word : resultArray) {
			resultList.add(word);
		}
		testExecutionContext.setValue(resultName, resultList, resultScope);
	}

}
