package pet.project.Messenger.servise;

import pet.project.Messenger.dto.UserDto;
import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.UserRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;



@Repository
public class UserService{

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public HashMap<String, String> getUsernamesOfUsersById(Collection<UUID> usersId){
		HashMap<String, String> result = new HashMap<String, String> ();
		Iterator<User> iterUser =  userRepository.findByIdIsIn(usersId).iterator();
		while(iterUser.hasNext()) {
			User user = iterUser.next();
			result.put(user.getId().toString(), user.getUsername());
		}
		return result;
	}
	
	public List<UserDto> getUsersWithUsernameLike(String username){
		return userRepository.findByUsernameLike(username).stream().map(user -> new UserDto(user.getId(),user.getUsername())).toList();
	}
}
