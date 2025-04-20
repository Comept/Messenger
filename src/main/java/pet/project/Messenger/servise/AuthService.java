package pet.project.Messenger.servise;


import pet.project.Messenger.dto.user.UserRegisterDto;
import pet.project.Messenger.exception.UserAlreadyExistsException;

public interface AuthService {
	void register(UserRegisterDto userRegisterDto) throws UserAlreadyExistsException;

	boolean verifyUser(String verificationToken);
}