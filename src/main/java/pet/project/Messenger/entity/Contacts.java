package pet.project.Messenger.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contacts {
	@Id
    private long userId;
    private long contactId;
    private Date createdAt;

    public Contacts() {
    }

    public Contacts(long userId, long contactId) {
        setUserId(userId);
        setContactId(contactId);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}