package pet.project.Messenger.model;


import java.util.Date;
import java.util.UUID;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User implements UserDetails, Serializable{

	private static final long serialVersionUID = 406212719119135517L;
	@Id
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private UUID id;
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private String username;
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
    private String email;
    private String password;
    @Builder.Default
    private Date createdAt = new Date();    
    
	public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("USER_ROLE"));
	}
}