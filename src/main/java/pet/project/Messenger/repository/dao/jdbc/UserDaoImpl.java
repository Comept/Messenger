package pet.project.Messenger.repository.dao.jdbc;

import pet.project.Messenger.entity.User;
import pet.project.Messenger.repository.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Component
public class UserDaoImpl {

	private final UserDao userdao;

	public UserDaoImpl(@Lazy UserDao userdao) {
		super();
		this.userdao = userdao;
	}
	public long saveNewUser(User user) {
		userdao.save(user);
		return 100;	
	}
}
