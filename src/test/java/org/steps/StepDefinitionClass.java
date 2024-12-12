package org.steps;

import java.util.ArrayList;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class StepDefinitionClass extends BaseClass{
	
	@Given("User creates the request object")
	public void user_creates_the_request_object() {
	    requestObject("https://petstore.swagger.io");
	}
	@When("User attaches the payload")
	public void user_attaches_the_payload() {
		header("Content-Type", "application/json");
		ArrayList<Tags> tags = new ArrayList();
		Tags tags1 = new Tags(0, "string");
		tags.add(tags1);
		ArrayList<String> photoUrls = new ArrayList();
		photoUrls.add("string");
		Category category = new Category(0, "string");
	    Root root = new Root(0, category, "doggie", photoUrls, tags, "available");
	    //to attach the payload using serialization
	    requestSpecification.body(root);
	}
	@When("User creates the response object")
	public void user_creates_the_response_object() {
	    responseObject("POST", "/v2/pet");
	}
	@Then("User validates the response code and body")
	public void user_validates_the_response_code_and_body() {
	    responseCode();
	    responseBody();
	    Headers headers = response.headers();
	    Header header = headers.get("Content-Type");
	    System.out.println(header);
	}




}
