package pet.project.Messenger.dto;

import java.util.HashMap;
import java.util.List;

import pet.project.Messenger.model.Messages;
import pet.project.Messenger.model.User;

public class ChatDto {
	private List<Long> membersIds; 
	private HashMap<Long, String> UserIdAndUsername;
	private HashMap<Long, String> UserIdAndRole;
	private List<Messages> messages; 
	private String chatName;
	
	public List<Long> getMembersIds() {
		return membersIds;
	}
	public void setMembersIds(List<Long> members) {
		this.membersIds = members;
	}
	public HashMap<Long, String> getUserIdAndUsername() {
		return UserIdAndUsername;
	}
	public void setUserIdAndUsername(HashMap<Long, String> userIdAndUsername) {
		UserIdAndUsername = userIdAndUsername;
	}
	public HashMap<Long, String> getUserIdAndRole() {
		return UserIdAndRole;
	}
	public void setUserIdAndRole(HashMap<Long, String> userIdAndRole) {
		UserIdAndRole = userIdAndRole;
	}
	public List<Messages> getMessages() {
		return messages;
	}
	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	public String getChatName() {
		return chatName;
	}
	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	public void addMember(long userId, String username, String role) {
		membersIds.add(userId);
		UserIdAndUsername.put(userId, username);
		UserIdAndUsername.put(userId, role);
	}
	
}
