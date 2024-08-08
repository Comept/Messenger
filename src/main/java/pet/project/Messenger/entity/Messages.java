package pet.project.Messenger.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Messages {
	@Id
    private long messageId;
    private long chatId;
    
	private long senderId;
    private String messageText;
    private Date sentAt;

    public Messages() {
    }

    public Messages(long messageId, long chatId, long senderId, String messageText, Date sentAt) {
        setMessageId(messageId);
        setChatId(chatId);
        setSenderId(senderId);
        setMessageText(messageText);
        setSentAt(sentAt);
    }

    public Messages(long chatId, long senderId, String messageText) {
        setChatId(chatId);
        setSenderId(senderId);
        setMessageText(messageText);
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
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