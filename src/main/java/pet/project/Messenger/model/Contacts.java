package pet.project.Messenger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import pet.project.Messenger.model.PrimeryKeyses.ContactsPK;

@Entity
@IdClass(ContactsPK.class)
public class Contacts implements Serializable{
	@Id
	@Column(name="user1_id")
	private long userId1;
	@Id
	@Column(name="user2_id")
	private long userId2;
    private Date createdAt;
	public long getUserId1() {
		return userId1;
	}
	public void setUserId1(long userId1) {
		this.userId1 = userId1;
	}
	public long getUserId2() {
		return userId2;
	}
	public void setUserId2(long userId2) {
		this.userId2 = userId2;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Contacts(long userId1, long userId2, Date createdAt) {
		super();
		this.userId1 = userId1;
		this.userId2 = userId2;
		this.createdAt = createdAt;
	}
	public Contacts() {
		super();
	}
	
	
}