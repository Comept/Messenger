package pet.project.Messenger.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pet.project.Messenger.entity.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{
	public List<User> readByUsername(String username);
	public User findjjhjj(String name);
}
