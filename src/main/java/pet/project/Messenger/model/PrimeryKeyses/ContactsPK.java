package pet.project.Messenger.model.PrimeryKeyses;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import pet.project.Messenger.model.User;

@Embeddable
public class ContactsPK implements Serializable{
	private User user_id;
	private User contact_id;
	public ContactsPK() {
		super();
	}
	public ContactsPK(User user_id, User contact_id) {
		super();
		this.user_id = user_id;
		this.contact_id = contact_id;
	}
	public User getUser() {
		return user_id;
	}
	public void setUser(User user_id) {
		this.user_id = user_id;
	}
	public User getcontact_id() {
		return contact_id;
	}
	public void setcontact_id(User contact_id) {
		this.contact_id = contact_id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(contact_id, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactsPK other = (ContactsPK) obj;
		return Objects.equals(contact_id, other.contact_id) && Objects.equals(user_id, other.user_id);
	}
	@Override
	public String toString() {
		return "ContactsPK [user_id=" + user_id + ", contact_id=" + contact_id + "]";
	}
}