package pet.project.Messenger.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Message implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private long id;
    private long chatId;
	private long senderId;
    private String messageText;
    private Date sentAt;

    public Message() {
    }

    public Message(long chatId, long senderId, String messageText, Date sentAt) {
        setChatId(chatId);
        setSenderId(senderId);
        setMessageText(messageText);
        setSentAt(sentAt);
    }

    public Message(long chatId, long senderId, String messageText) {
        setChatId(chatId);
        setSenderId(senderId);
        setMessageText(messageText);
    }

    public long getId() {
        return id;
    }

    public void setId(long messageId) {
        this.id = messageId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }
}