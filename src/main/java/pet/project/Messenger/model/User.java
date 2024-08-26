package pet.project.Messenger.model;


import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User implements UserDetails, Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private Long id;
    private String username;
    private String password_hash;
    private String email;
    private Date createdAt;
    
    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public User(Long id, String username, String password, String email, Date createdAt) {
    	setUserId(id);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setCreatedAt(createdAt);
    }
    
    

    public User(String username, String password_hash, String email, Date createdAt) {
		super();
		this.username = username;
		this.password_hash = password_hash;
		this.email = email;
		this.createdAt = createdAt;
	}

	public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }
    
    public User() {
    }

	public User(int i, String string) {
		// TODO Auto-generated constructor stub
		this.id = (long) i;
		this.username = string;
		
	}



	public Long getUserId() {
        return id;
    }

	public void setUserId(Long userId) /*throw*/{
        if(this.id == 0);
        this.id = userId;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("USER_ROLE"));
	}
	
    @Override
	public int hashCode() {
		return Objects.hash(createdAt, email, password_hash, id, username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password_hash=" + password_hash + ", email="
				+ email + ", createdAt=" + createdAt + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(email, other.email)
				&& Objects.equals(password_hash, other.password_hash) && Objects.equals(id, other.id)
				&& Objects.equals(username, other.username);
	}
}