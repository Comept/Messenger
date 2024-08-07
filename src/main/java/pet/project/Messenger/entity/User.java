package pet.project.Messenger.entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("users")
public class User {
	@Id
	@Column("user_id")
    private Long userId;
    private String username;
    @Column("password_hash")
    private String password;
    private String email;
    @Column("created_at")
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
		this.password = password;
		this.email = email;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) /*throw*/{
        if(this.userId == 0);
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) /*throw*/{
        if(this.username == null);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) /*throw*/{
        if(this.password == null);
        this.password = password;
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