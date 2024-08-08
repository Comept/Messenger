package pet.project.Messenger.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="users")
public class User {
	@Id
    private Long user_Id;
    private String username;
    private String password_hash;
    private String email;
    private Date createdAt;
    
    public User(Long userId, String username, String password, String email, Date createdAt) {
        setUserId(userId);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setCreatedAt(createdAt);
    }

    public User() {
    }

    

	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password_hash = password;
		this.email = email;
	}

	public Long getUserId() {
        return user_Id;
    }

    public void setUserId(Long userId) /*throw*/{
        if(this.user_Id == 0);
        this.user_Id = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) /*throw*/{
        if(this.username == null);
        this.username = username;
    }

    public String getPassword() {
        return password_hash;
    }

    public void setPassword(String password) /*throw*/{
        if(this.password_hash == null);
        this.password_hash = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) /*throw*/{
        if(this.email == null);
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) /*throw*/{
        if(this.createdAt == null);
        this.createdAt = createdAt;
    }

}