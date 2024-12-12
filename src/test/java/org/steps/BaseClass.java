package org.steps;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	// Reusable Methods
		// 1. User defined method
		// 2. Write original logic inside the method
		// 3. Convert input into arguments, output into return types

		public static RequestSpecification requestSpecification;
		public static Response response;

		// 1. Request Object
		public static void requestObject(String baseURI) {
			RestAssured.baseURI = baseURI;
			requestSpecification = RestAssured.given();
		}

		// 2. Payload attach
		public static void attachPayload(JSONObject jsonObject) {
			requestSpecification.body(jsonObject.toJSONString());
		}

		public static void attachPayload(HashMap<String, Object> hashMap) {
			requestSpecification.body(hashMap);
		}

		// 3. Query Parameter
		public static void queryParameter(String parameterName, String parameterValue) {
			requestSpecification.queryParam(parameterName, parameterValue);
		}

		// 4. Path Parameter
		public static void pathParmeter(String parameterName, String parameterValue) {
			requestSpecification.pathParam(parameterName, parameterValue);
		}

		// 5. Response Object
		public static void responseObject(String requestType, String endPoint) {
			switch (requestType) {
			case "GET": {
				response = requestSpecification.request(Method.GET, endPoint);
				break;
			}
			case "POST": {
				response = requestSpecification.request(Method.POST, endPoint);
				break;
			}
			case "PUT": {
				response = requestSpecification.request(Method.PUT, endPoint);
				break;
			}
			default: {
				response = requestSpecification.request(Method.DELETE, endPoint);
			}
			}
			;
		}

		// 6. Header
		public static void header(String headerName, String headerValue) {
			requestSpecification.header(headerName, headerValue);
		}

		// 7. Authentication Token
		public static void authToken(String userName, String password) {
			requestSpecification.auth().basic(userName, password);
		}
		
		public static void authToken(String token) {
			requestSpecification.auth().oauth2(token);
		}

		// 8. Response Code
		public static void responseCode() {
			System.out.println(response.getStatusCode());
		}

		// 9. Response Body
		public static void responseBody() {
			System.out.println(response.getBody().asPrettyString());
		}


}
