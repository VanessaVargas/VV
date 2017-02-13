package altair;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProfileStepDefinitions {
	
	final static Logger logger = Logger.getLogger(ProfileStepDefinitions.class);
	private static Response profileCreated;
	
	public static Response getProfileCreated()
	{
		return profileCreated;
	}
	
	@When("^I create a profile$")
	public void I_create_a_profile()
	{
		Map<String, Object>  requestBody = new HashMap<>();
		requestBody.put("profileName", "Test12");
		requestBody.put("firstName", "Test127123");
		requestBody.put("lastName", "abc@gmail.com");
		
		profileCreated = given(). // NOSONAR
				accept(ContentType.JSON).
				contentType(ContentType.JSON).
				body(requestBody).
        when().
        	post("http://localhost:8585/altair/rest/profiles");
		
		logger.info("Object Created:" + profileCreated.getBody().asString());
	}
	
	@Then("^The profile should be saved$")
	public void The_profile_should_be_saved()
	{
		String profile = getProfileCreated().getBody().asString();
		String id = getProfileCreated().getBody().jsonPath().getObject("id", String.class);
		
		given().
				contentType(ContentType.JSON).
        when().
			get("http://localhost:8585/altair/rest/profiles/" + id).
    	then().
	        body(containsString(profile)).
	        statusCode(200);
	}
}
