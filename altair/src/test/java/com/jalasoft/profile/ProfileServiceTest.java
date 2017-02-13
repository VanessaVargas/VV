package com.jalasoft.profile;

import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Test;

import com.jalasoft.database.DatabaseClass;
import com.jalasoft.model.Profile;
import com.jalasoft.resources.ProfileResource;

public class ProfileServiceTest{
	
	ProfileResource profileResource = new ProfileResource();
	
	// Test for endpoint GET /profiles
	@Test
	public void testGetProfiles()
	{
		Response response = profileResource.getProfiles();
		int profilesSize = DatabaseClass.getProfiles().size();
		
		@SuppressWarnings("unchecked")
		List<Profile> payload = (List<Profile>) response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertEquals(200, response.getStatus());
		Assert.assertEquals(profilesSize, payload.size());
	}
	
	// Test for endpoint POST /profiles
	@Test
	public void testAddProfile()
	{
		int profilesSize = DatabaseClass.getProfiles().size();
		Profile newProfile = new Profile(profilesSize + 1, "test", "test", "test");
		
		Response response = profileResource.addProfile(newProfile);
		Profile payload = (Profile) response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertEquals(201, response.getStatus());
		Assert.assertEquals(newProfile, payload);
	}
	
	// Test for endpoint GET profiles/{profileId}
	@Test
	public void testGetProfile()
	{
		Profile firstProfile = DatabaseClass.getProfiles().get(1L);
		
		Response response = profileResource.getProfile(firstProfile.getId());
		Profile payload = (Profile) response.getEntity();
		
		Assert.assertNotNull(response);
		Assert.assertEquals(200, response.getStatus());
		Assert.assertEquals(firstProfile, payload);
	}	
}
