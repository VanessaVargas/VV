package com.jalasoft.profile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ProfileServiceTest{
	
	@Test
	public void getallProfiles() {
	    given().
	        contentType("application/json").
	    when().
	        get("/altair/rest/profiles").
	    then().
	        body(containsString("profileName")).
	        body(containsString("firstName")).
	        body(containsString("lastName")).
	        statusCode(200);
	}
	
	@Test
	public void getProfile() {
	    given().
	        contentType("application/json").
	    when().
	        get("/altair/rest/profile/1").
	    then().
	        body(containsString("profileName")).
	        body(containsString("firstname")).
	        body(containsString("lastName")).
	        statusCode(200);
	}
	
}
