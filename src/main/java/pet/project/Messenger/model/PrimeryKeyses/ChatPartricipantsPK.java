package pet.project.Messenger.model.PrimeryKeyses;

import java.io.Serializable;

public class ChatPartricipantsPK implements Serializable{
	private long chatId;
    private long userId;
	public long getChatId() {
		return chatId;
	}
	public void setChatId(long chatId) {
		this.chatId = chatId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public ChatPartricipantsPK(long chatId, long userId) {
		super();
		this.chatId = chatId;
		this.userId = userId;
	}
	public ChatPartricipantsPK() {
		super();
	}
    
}
