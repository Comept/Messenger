package pet.project.Messenger.dto;

import java.util.List;

import lombok.Data;
import pet.project.Messenger.model.Contacts;

public class CreatChatDto {
	private String chatName;
	private List<Long> contacts;
	public String getChatName() {
		return chatName;
	}
	public void setChatName(String chatName) {
		this.chatName = chatName;
	}
	public List<Long> getContacts() {
		return contacts;
	}
	public void setContacts(List<Long> contacts) {
		this.contacts = contacts;
	}
	public CreatChatDto(String chatName, List<Long> contacts) {
		super();
		this.chatName = chatName;
		this.contacts = contacts;
	}
	public CreatChatDto() {
		super();
	}
}
