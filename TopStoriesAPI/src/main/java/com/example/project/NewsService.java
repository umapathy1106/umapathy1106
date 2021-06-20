package com.example.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService<topstoriesList>
{	
public News getTopStories()
{
//Initialize the rest template, topstories list and an empty jsonObject	
List<News> topstoriesList = new ArrayList<>();
RestTemplate restTemplate = new RestTemplate();

//Set up the URL to invoke 
String url = "https://api.nytimes.com/svc/topstories/v2/science.json?api-key=4BD3Lhl9GYmcdIj7jjpn9qcF2BnNQVNO";
News news = new News();

//Set up the Header to accept the incoming request as JSON
HttpHeaders headers  = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);

//Establish the Request Entity and Invoke the GET API
HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
JSONObject jsonObject;

//Capture the Status code, Status code value and Headers - Just to ensure the GET Call is success !! 
HttpStatus statuscode = responseEntity.getStatusCode();
HttpHeaders headers_print = responseEntity.getHeaders();
int statuscode_value = responseEntity.getStatusCodeValue();

//Print the Captured Values to the Console
System.out.println("HTTP Response code from NEWS API : " +statuscode);
System.out.println("Headers Printed from NEWS API : " +headers_print);
System.out.println("Status Code Value Printed from NEWS API : " +statuscode_value);

/*If the Status code from the API is Ok, then run the loop to extract only the title and section values from the newsList object and return it. */ 

if(responseEntity.getStatusCode() == HttpStatus.OK)
{
	 //Load the Response Entity obtained from the API call into JSON Object 
     jsonObject = new JSONObject(responseEntity.getBody());
	 JSONArray jsonArray = jsonObject.getJSONArray("results");
	 Results[] results = new Results[jsonArray.length()];
	
  for(int i=0; i < jsonArray.length() ; i++) 
      { 
		news.setTitle(jsonArray.getJSONObject(i).get("title").toString());
		news.setSection(jsonArray.getJSONObject(i).get("section").toString());
			
		//Capturing the JSON Response Objects and print to console 
		String title = jsonArray.getJSONObject(i).get("title").toString();
		System.out.println("Value of Title : " +title);
			
		String section = jsonArray.getJSONObject(i).get("section").toString();
		System.out.println("Value of Section : " +section);
		   			
		results[i] = new Results();
	    results[i].setTitle(title);
	
		news.setResults(results);
		topstoriesList.add(news);
    	}
     System.out.println("Length of the Result Array : " +results.length);
     System.out.println(Arrays.deepToString(results));
        
	}
return topstoriesList.get(0);
}
}
