package customapis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.TestApi;
import com.provar.core.testapi.annotations.TestApiExecutor;
import com.provar.core.testapi.annotations.TestApiParameter;
import com.provar.core.testapi.annotations.TestApiParameterGroup;
import com.provar.core.testapi.annotations.TestApiParameterGroups;
import com.provar.core.testapi.annotations.TestExecutionContext;
import com.provar.core.testapi.annotations.TestLogger;

@TestApi(title = "Compare Word File", summary = "", remarks = "", iconBase = "", defaultApiGroups = { "Custom" })
@TestApiParameterGroups(parameterGroups = { @TestApiParameterGroup(groupName = "inputs", title = "Inputs"),
		@TestApiParameterGroup(groupName = "result", title = "Result"), })
public class CompareWordFile {

	@TestApiParameter(seq = 1, summary = "The first parameter's summary.", remarks = "", mandatory = true, parameterGroup = "inputs")
	public String File1;

	@TestApiParameter(seq = 2, summary = "The second parameter's summary.", remarks = "", mandatory = true, parameterGroup = "inputs")
	public String File2;

//	@TestApiParameter(seq = 10, summary = "The name that the result will be stored under.", remarks = "", mandatory = true, parameterGroup = "result")
//	public String resultName;
//
//	@TestApiParameter(seq = 11, summary = "The lifespan of the result.", remarks = "", mandatory = true, parameterGroup = "result", defaultValue = "Test")
//	public ValueScope resultScope;

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
	public void execute() throws IOException {

		if (readEveryWord1().size() != readEveryWord2().size()) {
			testLogger.severe("Data Mismatched");
			return;
		}

		for (int i = 0; i < readEveryWord1().size(); i++) {
			if (!readEveryWord1().get(i).equalsIgnoreCase(readEveryWord2().get(i))) {
				testLogger.severe("Data Mismatched");
				return;
			}
		}

		testLogger.info("File Data Matched");

	}

	public String readWordFile1() throws IOException {
		XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(File1)));
		return new XWPFWordExtractor(doc).getText();

	}

	public List<String> readEveryWord1() throws IOException {
		String[] resultArray = readWordFile1().split("\\s+");
		List<String> resultList = new ArrayList<String>();
		for (String word : resultArray) {
			resultList.add(word);
		}
		return resultList;
	}

	public String readWordFile2() throws IOException {
		XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(File2)));
		return new XWPFWordExtractor(doc).getText();

	}

	public List<String> readEveryWord2() throws IOException {
		String[] resultArray = readWordFile2().split("\\s+");
		List<String> resultList = new ArrayList<String>();
		for (String word : resultArray) {
			resultList.add(word);
		}

		return resultList;
	}

}
