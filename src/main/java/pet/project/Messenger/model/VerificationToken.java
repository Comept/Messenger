package pet.project.Messenger.model;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash("VerificationToken")
public class VerificationToken {

	@Id
	private String token;

	private Long userId;

	@TimeToLive(unit = TimeUnit.HOURS)
	private Long expiration = 24L;

	private LocalDateTime createdAt = LocalDateTime.now();

	public VerificationToken(String token, Long userId) {
		super();
		this.token = token;
		this.userId = userId;
		this.createdAt = LocalDateTime.now();
	}

}
