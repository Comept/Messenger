package pet.project.Messenger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pet.project.Messenger.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	public List<User> readByUsername(String username);
}
