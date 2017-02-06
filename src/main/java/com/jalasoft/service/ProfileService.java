package com.jalasoft.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jalasoft.database.DatabaseClass;
import com.jalasoft.model.ErrorMessage;
import com.jalasoft.model.Profile;

public class ProfileService {

	private Map<Long, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() // NOSONAR
	{
		
	}
	
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfile(long profileId)
	{
		ErrorMessage errorMessage = new ErrorMessage("Profile not found", 404);
		Response response = Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		Profile profile =  profiles.get(profileId);		
		
		if (profile == null) {
			throw new NotFoundException(response);
		}
		
		return profile;
	}
	
	public Profile addProfile(Profile profile)
	{
		profile.setId((long)profiles.size() + 1L);
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile)
	{
		if (profile.getId() <= 0)
		{
			return null;
		}
		profiles.put(profile.getId(), profile);
		return profile;	
	}
	
	public Profile removeProfile(long profileId)
	{
		return  profiles.remove(profileId);
	}
	
}
