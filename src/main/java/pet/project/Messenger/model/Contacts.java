package pet.project.Messenger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import pet.project.Messenger.model.PrimeryKeyses.ContactsPK;

@Entity

public class Contacts implements Serializable{
	@MapsId("user_id")
	@ManyToOne
    private User user;
	@MapsId("contact_id")
	@ManyToOne
    private User contactUser;
	@EmbeddedId
	private ContactsPK contactsPK;
    private Date createdAt;
    
    
    
    public Contacts() {
    }



    public Contacts(User user, User contactUser) {
		super();
		this.user = user;
		this.contactUser = contactUser;
		this.createdAt = new Date();
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public User getContactUser() {
		return contactUser;
	}



	public void setContactUser(User contactUser) {
		this.contactUser = contactUser;
	}



	public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



	public ContactsPK getContactsPK() {
		return contactsPK;
	}



	public void setContactsPK(ContactsPK contactsPK) {
		this.contactsPK = contactsPK;
	}



	@Override
	public int hashCode() {
		return Objects.hash(contactUser, createdAt, user);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacts other = (Contacts) obj;
		return Objects.equals(contactUser, other.contactUser) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(user, other.user);
	}



	@Override
	public String toString() {
		return "Contacts [user=" + user + ", contactUser=" + contactUser + ", createdAt=" + createdAt + "]";
	}

    
}