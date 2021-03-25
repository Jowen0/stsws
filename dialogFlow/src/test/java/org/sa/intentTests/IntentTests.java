package org.sa.intentTests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sa.util.DetectIntentTexts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.QueryResult;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class IntentTests {
	
	@Autowired
	private DetectIntentTexts tests;
	
	private static String projectID = "focused-elysium-308503";
	
	@Test
	public void intentTests() throws IOException {
		
		try {
			
			List<Intent> list = tests.listIntents("focused-elysium-308503");
			
			log.info(list);
			
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testDetect() {
		
		try {
			
			List<String> texts = new ArrayList<String>();
					
			texts.add("What is your name?");
			
			Map<String, QueryResult> map = tests.detectIntentTexts(projectID, texts, "12345678", "en-US");
			
			log.info(map.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
