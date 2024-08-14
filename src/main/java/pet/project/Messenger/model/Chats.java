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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String chatName;
  private boolean isGroup;

    public Chats() {
    }

    public Chats(long id, String chatName, boolean isGroup) {
        setId(id);
        setChatName(chatName);
        setIsGroup(isGroup);
    }

    public Chats(long id, String chatName) {
		super();
		this.id = id;
		this.chatName = chatName;
	}
    
    

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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