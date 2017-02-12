package com.jalasoft.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jalasoft.model.Profile;
import com.jalasoft.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService = new ProfileService();
	
	@GET
	public Response getProfiles()
	{
		List<Profile> profiles = profileService.getAllProfiles();
		
		GenericEntity<List<Profile>> profilesList = new GenericEntity<List<Profile>>(profiles) {};
		return Response.status(Status.OK)
				.entity(profilesList)
				.build();
	}
	
	@POST
	public Response addProfile(Profile profile)
	{
		Profile newProfile = profileService.addProfile(profile);
		return Response.status(Status.CREATED)
				.entity(newProfile)
				.build();
	}
	
	@GET
	@Path("/{profileId}")
	public Response getProfile(@PathParam("profileId") long profileId)
	{
		Profile profile = profileService.getProfile(profileId);
		return Response.status(Status.OK)
				.entity(profile)
				.build();
	}
	
	@PUT
	@Path("/{profileId}")
	public Profile updateProfile(@PathParam("profileId") long profileId, Profile profile)
	{
		profile.setId(profileId);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileId}")
	public void deleteProfile(@PathParam("profileId") long profileId)
	{
		profileService.removeProfile(profileId);
	}
	
	@Path("/{profileId}/messages")
	public MessageResource getMessageResource()
	{
		return new MessageResource();
	}
	
}
