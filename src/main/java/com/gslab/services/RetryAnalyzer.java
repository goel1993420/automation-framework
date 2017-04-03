package com.gslab.services;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
   
	int count=0;
	int retryLimit= 1;
	
	
	
	public boolean retry(ITestResult result) {
		if(count<retryLimit){
			
			count++;
			return true;
			
		}
		return false;
	}
	
	

}
