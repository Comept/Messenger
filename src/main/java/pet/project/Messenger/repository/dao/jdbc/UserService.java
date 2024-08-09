package pet.project.Messenger.repository.dao.jdbc;

import pet.project.Messenger.entity.User;
import pet.project.Messenger.repository.dao.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public class UserService{

	private final UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public User findjjhjj(String name) {
		return userRepo.readByUsername(name).getFirst();
	}
	
}
