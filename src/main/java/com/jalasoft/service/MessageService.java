package com.jalasoft.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jalasoft.database.DatabaseClass;
import com.jalasoft.model.Message;
import com.jalasoft.model.Profile;

public class MessageService {
	
	private Map<Long, Profile> profiles = DatabaseClass.getProfiles();
	
	public MessageService() // NOSONAR
	{
		
	}
	
	public List<Message> getAllMessages(long profileId)
	{
		Map<Long, Message> messages = profiles.get(profileId).getMessages();
		return new ArrayList<>(messages.values());
	}
	
	public Message getMessage(long profileId, long messageId)
	{
		Profile profile = profiles.get(profileId);
		Map<Long, Message> messages = profile.getMessages();
		return messages.get(messageId);		
	}
	
	public Message addMessage(long profileId, Message message)
	{
		Map<Long, Message> messages = profiles.get(profileId).getMessages();
		message.setId((long)messages.size() + 1L);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(long profileId, Message message)
	{
		
		Map<Long, Message> messages = profiles.get(profileId).getMessages();
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long profileId, long messageId)
	{
		Map<Long, Message> messages = profiles.get(profileId).getMessages();
		return messages.remove(messageId);
	}

}
