
package TestListeners;

import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.utils.ConfigReader;
import base.utils.EnvironmentFileUtil;
import base.utils.XrayUtil;
import io.qameta.allure.TmsLink;

public class TestListener implements ITestListener, IExecutionListener {

	static WebDriver listenerDriver;

	@Override
	public synchronized void onTestStart(ITestResult result) {
		TmsLink testKey;
		String testRunID;
		try {
			if (ConfigReader.getValue("updateTestStatus").equals("true")) {
				testKey = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TmsLink.class);
				String projectName=testKey.value();
				if (projectName.contains("YET")){
					projectName=testKey.value().substring(0, 4);
				}
				else {
					projectName = testKey.value().substring(0, 3);
				}
				testRunID = XrayUtil.getTestRun(testKey.value(), projectName);
				XrayUtil.updateTestRun(testRunID, "executing");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		TmsLink testKey;
		String testRunID;
		try {
			if (ConfigReader.getValue("updateTestStatus").equals("true")) {
				testKey = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TmsLink.class);
				String projectName = testKey.value().substring(0, 3);
				testRunID = XrayUtil.getTestRun(testKey.value(), projectName);
				XrayUtil.updateTestRun(testRunID, "passed");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		TmsLink testKey;
		String testRunID;
		try {
			if (ConfigReader.getValue("updateTestStatus").equals("true")) {
				testKey = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TmsLink.class);
				String projectName = testKey.value().substring(0, 3);
				testRunID = XrayUtil.getTestRun(testKey.value(), projectName);
				XrayUtil.updateTestRun(testRunID, "failed");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		TmsLink testKey;
		String testRunID;
		try {
			if (ConfigReader.getValue("updateTestStatus").equals("true")) {
				testKey = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TmsLink.class);
				String projectName = testKey.value().substring(0, 3);
				testRunID = XrayUtil.getTestRun(testKey.value(), projectName);
				XrayUtil.updateTestRun(testRunID, "failed");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public static void setListenerDriver(WebDriver driver) {

		listenerDriver = driver;
	}

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onExecutionFinish() {
		EnvironmentFileUtil.generateEnvironmentPropFile();
		ConfigReader.setValue("updateTestStatus", "false");
	}

}
