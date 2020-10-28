package com.apitesting

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.ArrayList

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent


import internal.GlobalVariable


public class ApiTesting {
	String url = "https://apidev.mile.app/v1/request_demo"
	String requestMethod = "POST"

	TestObjectProperty header1 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
	ArrayList defaultHeaders = Arrays.asList(header1)

	String body1 = '{"full_name":"Imam Setya Utama","email":"utamaimam04@gmail.com","phone":"0895403495533","organization_name":"BRI"}'
	String body2 = '{"full_name":"Riskha","email":"riskha@gmail.com","phone":"0895403495533","organization_name":"BRI"}'


	/**
	 * POST requests
	 * @return
	 */
	@Keyword
	public ResponseObject apiTestingBuild1() {
		def ro = (RequestObject)findTestObject("post-api")
		ro.setRestUrl(url)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body1))

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}

	@Keyword
	public ResponseObject apiTestingBuild2() {
		RequestObject ro = new RestRequestObjectBuilder()
				.withRestUrl(url)
				.withHttpHeaders(defaultHeaders)
				.withRestRequestMethod("POST")
				.withTextBodyContent(body2)
				.build()

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}
}
