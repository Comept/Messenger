package pet.project.Messenger.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Chats {
  @Id
  @Column("chat_id")
  private long chatId;
  @Column("chat_name")
  private String chatName;
  @Column("is_group")
  private boolean isGroup;

    public Chats() {
    }

    public Chats(long chatId, String chatName, boolean isGroup) {
        setChatId(chatId);
        setChatName(chatName);
        setIsGroup(isGroup);
    }

    public Chats(long chatId, String chatName) {
		super();
		this.chatId = chatId;
		this.chatName = chatName;
	}

	public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public boolean getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(boolean isGroup) {
        this.isGroup = isGroup;
    }
}