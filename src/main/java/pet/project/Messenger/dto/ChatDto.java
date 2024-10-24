package pet.project.Messenger.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import pet.project.Messenger.model.Message;

public class ChatDto {

	private long userId;
	private List<ChatParticipantsDto> members = new ArrayList();
	private List<Message> messages; 
	private String chatName;

	
	
	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public List<ChatParticipantsDto> getMembers() {
		return members;
	}


	public void setMembers(List<ChatParticipantsDto> members) {
		this.members = members;
	}

	public List<Message> getMessages() {
		return messages;
	}


	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}


	public String getChatName() {
		return chatName;
	}


	public void setChatName(String chatName) {
		this.chatName = chatName;
	}
	
	public String getParticipantUsernameById(long id) {
		String a = "";
		Iterator<ChatParticipantsDto> memberIter = members.iterator();
		while(memberIter.hasNext()) {
			ChatParticipantsDto member = memberIter.next();
			if(member.getUserId() == id) return member.getUsername();
			a += member.getUserId() + "   ";
		}
		return a;
	}
	
	
}
