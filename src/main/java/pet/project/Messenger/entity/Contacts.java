package pet.project.Messenger.entity;

import java.sql.Date;

import org.springframework.data.relational.core.mapping.Column;

public class Contacts {
	@Column("user_id")
    private long userId;
	@Column("contact_id")
    private long contactId;
	@Column("created_at")
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