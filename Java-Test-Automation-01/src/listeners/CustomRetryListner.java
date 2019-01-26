package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import customAnnotations.RetryCountIfFailed;

public class CustomRetryListner implements IRetryAnalyzer{

	
	int retryCount =1;
	static final int maxRetryCount=5;
	
	
//	@Override
//	public boolean retry(ITestResult arg0) {
//		
//		if(arg0.getStatus() == ITestResult.FAILURE && retryCount <= maxRetryCount) {
//			
//		try { Thread.sleep(3000);
//		System.out.println(String.format("Method Name : %s Retry Count : %d", arg0.getMethod(),retryCount));
//		retryCount++;
//		return true;
//		}	catch (Exception e){  
//			
//		}
//		}	
//		return false;
//	}

	int counter = 0;

	@Override
	public boolean retry(ITestResult result) {

		System.out.println("------------------Re Trying TestCase------------------");
		
		// check if the test method had RetryCountIfFailed annotation
		RetryCountIfFailed annotation = result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(RetryCountIfFailed.class);
		// based on the value of annotation see if test needs to be rerun
		if((annotation != null) && (counter < annotation.value()))
		{
			counter++;
			return true;
		}
		return false;
	}
}
