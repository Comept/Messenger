package entity;

import java.sql.Time;
import java.time.LocalDate;

public class Messages {
    private long messageId;
    private long chatId;
    private long senderId;
    private String messageText;
    private Time sentAt;

    public Messages() {
    }

    public Messages(long messageId, long chatId, long senderId, String messageText, Time sentAt) {
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

    public Time getSentAt() {
        return sentAt;
    }

    public void setSentAt(Time sentAt) {
        this.sentAt = sentAt;
    }
}