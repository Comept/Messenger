package pet.project.Messenger.servise.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pet.project.Messenger.dto.user.UserRegisterDto;
import pet.project.Messenger.exception.UserAlreadyExistsException;
import pet.project.Messenger.model.Profile;
import pet.project.Messenger.model.User;
import pet.project.Messenger.model.VerificationToken;
import pet.project.Messenger.repository.ProfileRepository;
import pet.project.Messenger.repository.UserRepository;
import pet.project.Messenger.repository.VerificationTokenRepository;
import pet.project.Messenger.servise.AuthService;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final ProfileRepository profileRepository;
	private final VerificationTokenRepository tokenRepository;
	private final JavaMailSender mailSender;

	@Override
	public void register(UserRegisterDto userRegisterDto) throws UserAlreadyExistsException {

		if (userRepository.existsByEmail(userRegisterDto.getEmail())) {
			throw new UserAlreadyExistsException("Email уже используется");
		}

		if (userRepository.existsByUsername(userRegisterDto.getUsername())) {
			throw new UserAlreadyExistsException("Имя пользователя уже занято");
		}

		if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
			throw new IllegalArgumentException("Пароли не совпадают");
		}
		User user = new User(userRegisterDto.getUsername(), userRegisterDto.getEmail(),
                passwordEncoder.encode(userRegisterDto.getPassword()));

Profile profile = new Profile();
profile.setUser(user);      
user.setProfile(profile);     

userRepository.save(user);     
        sendVerificationEmail(user);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

		return org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
				.password(user.getPasswordHash()).authorities(user.getAuthorities()).accountExpired(false)
				.accountLocked(false).credentialsExpired(false).disabled(user.getIsDeleted() || !user.getIsVerified())
				.build();
	}

	@Override
	public boolean verifyUser(String token) {
		Optional<VerificationToken> verificationTokenOptinal = tokenRepository.findById(token);
		if (verificationTokenOptinal.isEmpty()) {
			return false;
		}
		VerificationToken verificationToken = verificationTokenOptinal.get();
		User user = userRepository.findById(verificationToken.getUserId()).get();
		user.setIsVerified(true);
		userRepository.save(user);
		tokenRepository.delete(verificationToken);
		return true;
	}

	private void sendVerificationEmail(User user) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken(token, user.getId());
		tokenRepository.save(verificationToken);

		String verificationUrl = "http://localhost:8080/auth/verify?token=" + token;

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("Account Verification");
		mailMessage.setText("Please click the link to verify your account: " + verificationUrl);

		mailSender.send(mailMessage);
	}
}