package pet.project.Messenger.repository.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import pet.project.Messenger.entity.User;

@Component
public interface UserDao extends CrudRepository<User,Integer>{

}
