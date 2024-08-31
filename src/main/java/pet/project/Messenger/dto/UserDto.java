package pet.project.Messenger.dto;

public class UserDto {
	private long id;
	private String username;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserDto(long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + "]";
	}
	
}
