package pet.project.Messenger.security;
 
import java.util.Date;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import pet.project.Messenger.model.User;

@Component
public class RegistrationForm {
	private String username;
	private String email;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toUser(PasswordEncoder passwordEncoder) {
		
		return new User(UUID.randomUUID(),username, email, passwordEncoder.encode(password), new Date());
	}
	
	
}
