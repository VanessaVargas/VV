package com.jalasoft.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Profile {
	
	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date created;
	private Map<Long, Message> messages = new HashMap<>();
	
	public Profile() // NOSONAR
	{
		
	}	
	
	public Profile(long id, String profileName, String firstName, String lastName) 
	{
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}

	public long getId() 
	{
		return id;
	}
	
	public void setId(long id) 
	{
		this.id = id;
	}
	
	public String getProfileName() 
	{
		return profileName;
	}
	
	public void setProfileName(String profileName) 
	{
		this.profileName = profileName;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public Date getCreated() 
	{
		return created;
	}
	
	public void setCreated(Date created) 
	{
		this.created = created;
	}
	
	@XmlTransient
	public Map<Long, Message> getMessages()
	{
		return messages;
	}
	
	public void setMessages(Map<Long, Message> messages)
	{
		this.messages = messages;
	}
	
}
