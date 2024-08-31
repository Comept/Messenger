package pet.project.Messenger.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import pet.project.Messenger.model.Messages;
import pet.project.Messenger.model.User;

public class ChatDto {

	private List<ChatParticipantsDto> members = new ArrayList();
	private List<Messages> messages; 
	private String chatName;

	public List<ChatParticipantsDto> getMembers() {
		return members;
	}


	public void setMembers(List<ChatParticipantsDto> members) {
		this.members = members;
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
