package com.jalasoft.database;

import java.util.HashMap;
import java.util.Map;

import com.jalasoft.model.Message;
import com.jalasoft.model.Profile;

public class DatabaseClass {
	
	protected static final Map<Long, Message> messages = new HashMap<>();
	protected static final Map<Long, Profile> profiles = new HashMap<>();
	
	private static DatabaseClass database = new DatabaseClass();
	
	private DatabaseClass() 
	{
		Profile p1 = new Profile(1L, "Adlet", "Adlet", "Mayer");
		Profile p2 = new Profile(2L, "Fremy", "Fremy", "Speeddraw");
		
		profiles.put(1L, p1);
		profiles.put(2L, p2);		
	}
	
	public static DatabaseClass getInstance()
	{
		return database;
	}
	
	public static Map<Long, Message> getMessages()
	{
		return messages;
	}
	
	public static Map<Long, Profile> getProfiles()
	{
		return profiles;
	}

}
