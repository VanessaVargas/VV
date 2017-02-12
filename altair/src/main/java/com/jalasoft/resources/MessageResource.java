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
import javax.ws.rs.core.MediaType;

import com.jalasoft.model.Message;
import com.jalasoft.service.MessageService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@PathParam("profileId") long profileId)
	{
		return messageService.getAllMessages(profileId);
	}
	
	@POST
	public Message addMessage(@PathParam("profileId") long profileId, Message message)
	{
		return messageService.addMessage(profileId, message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("profileId") long profileId, @PathParam("messageId") long messagId, Message message)
	{
		message.setId(messagId);
		return messageService.updateMessage(profileId, message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("profileId") long profileId, @PathParam("messageId") long messagId)
	{
		messageService.removeMessage(profileId, messagId);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("profileId") long profileId, @PathParam("messageId") long messagId)
	{
		return messageService.getMessage(profileId, messagId);
	}

}
