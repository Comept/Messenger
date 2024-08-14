package pet.project.Messenger.model.PrimeryKeyses;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import pet.project.Messenger.model.User;


public class ContactsPK implements Serializable{
	private long userId1;
	private long userId2;
	public ContactsPK() {
		super();
	}
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
	public ContactsPK(long userId1, long userId2) {
		super();
		this.userId1 = userId1;
		this.userId2 = userId2;
	}
	@Override
	public String toString() {
		return "ContactsPK [userId1=" + userId1 + ", userId2=" + userId2 + "]";
	}
	
	
}