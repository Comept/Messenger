package pet.project.Messenger.servise;

import pet.project.Messenger.dto.UserDto;
import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.UserRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public class UserService{

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public HashMap<Long, String> getUsernamesOfUsersById(Collection<Long> usersId){
		HashMap<Long, String> result = new HashMap<Long, String> ();
		Iterator<User> iterUser =  userRepository.findByIdIsIn(usersId).iterator();
		while(iterUser.hasNext()) {
			User user = iterUser.next();
			result.put(user.getUserId(), user.getUsername());
		}
		return result;
	}
	
	public List<UserDto> getUsersWithUsernameLike(String username){
		return userRepository.findByUsernameLike(username).stream().map(user -> new UserDto(user.getUserId(),user.getUsername())).toList();
	}
}
