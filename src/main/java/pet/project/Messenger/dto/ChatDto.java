package pet.project.Messenger.dto;

import java.util.List;

import pet.project.Messenger.model.Messages;
import pet.project.Messenger.model.User;

public class ChatDto {
	
	private List<ChatMembers> members;
	private List<Messages> messages; 
	private String chatName;
	


	public ChatDto(List<Messages> messages, String chatName) {
		super();
		this.messages = messages;
		this.chatName = chatName;
	}

	public List<Messages> getMessages() {
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}

	public List<ChatMembers> getMembers() {
		return members;
	}

	public void addMember(long id, String username, String role) {
		this.members.add(new ChatMembers(id, username, role));
	}

	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	private class ChatMembers{
		private Long id;
		private String username;
		private String role;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return username;
		}
		public void setName(String name) {
			this.username = name;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public ChatMembers(Long id, String name, String role) {
			super();
			this.id = id;
			this.username = name;
			this.role = role;
		}
		
	}
}
