package pet.project.Messenger.model;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Chats {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long chatId;
  private String chatName;
  private boolean isGroup;
  
  @OneToMany(cascade = CascadeType.ALL)
  private List<Messages> messages = new ArrayList();
  
  public void addMessage(Messages message) { this.messages.add(message);
  }
  public void addMessages(List<Messages> messages) { this.messages.addAll(messages);
  }

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