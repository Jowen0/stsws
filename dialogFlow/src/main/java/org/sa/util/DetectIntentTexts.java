package org.sa.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.v2.AgentName;
import com.google.cloud.dialogflow.v2.Context;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.IntentsClient;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class DetectIntentTexts {
     // DialogFlow API Detect Intent sample with text inputs.
     public static Map<String, QueryResult> detectIntentTexts(
         String projectId, List<String> texts, String sessionId, String languageCode)
         throws IOException, ApiException {
       Map<String, QueryResult> queryResults = Maps.newHashMap();
       // Instantiates a client
       try (SessionsClient sessionsClient = SessionsClient.create()) {
         // Set the session name using the sessionId (UUID) and projectID (my-project-id)
         SessionName session = SessionName.of(projectId, sessionId);
         System.out.println("Session Path: " + session.toString());

         // Detect intents for each text input
         for (String text : texts) {
           // Set the text (hello) and language code (en-US) for the query
           TextInput.Builder textInput =
               TextInput.newBuilder().setText(text).setLanguageCode(languageCode);

           // Build the query with the TextInput
           QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

           // Performs the detect intent request
           DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

           // Display the query result
           QueryResult queryResult = response.getQueryResult();

           System.out.println("====================");
           System.out.format("Query Text: '%s'\n", queryResult.getQueryText());
           System.out.format(
               "Detected Intent: %s (confidence: %f)\n",
               queryResult.getIntent().getDisplayName(), queryResult.getIntentDetectionConfidence());
           System.out.format("Fulfillment Text: '%s'\n", queryResult.getFulfillmentText());

           queryResults.put(text, queryResult);
         }
       }
       return queryResults;
     }
     
     public static List<Intent> listIntents(String projectId) throws ApiException, IOException {
    	  List<Intent> intents = Lists.newArrayList();
    	  // Instantiates a client
    	  try (IntentsClient intentsClient = IntentsClient.create()) {
    	    // Set the project agent name using the projectID (my-project-id)
    	    AgentName parent = AgentName.of(projectId);

    	    // Performs the list intents request
    	    for (Intent intent : intentsClient.listIntents(parent).iterateAll()) {
    	      System.out.println("====================");
    	      System.out.format("Intent name: '%s'\n", intent.getName());
    	      System.out.format("Intent display name: '%s'\n", intent.getDisplayName());
    	      System.out.format("Action: '%s'\n", intent.getAction());
    	      System.out.format("Root followup intent: '%s'\n", intent.getRootFollowupIntentName());
    	      System.out.format("Parent followup intent: '%s'\n", intent.getParentFollowupIntentName());

    	      System.out.format("Input contexts:\n");
    	      for (String inputContextName : intent.getInputContextNamesList()) {
    	        System.out.format("\tName: %s\n", inputContextName);
    	      }
    	      System.out.format("Output contexts:\n");
    	      for (Context outputContext : intent.getOutputContextsList()) {
    	        System.out.format("\tName: %s\n", outputContext.getName());
    	      }

    	      intents.add(intent);
    	    }
    	  }
    	  return intents;
    	}
}