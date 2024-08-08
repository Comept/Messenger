package pet.project.Messenger.repository.dao.jdbc;

import pet.project.Messenger.entity.User;
import pet.project.Messenger.repository.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public class UserRepo implements UserDao{
	
	public User findjjhjj(String name) {
		return userdao.readByUsername(name).getFirst();
	}
	
}
