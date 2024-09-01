package pet.project.Messenger.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pet.project.Messenger.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	public User findByUsername(String username);
	public User findByEmail(String email);
	public List <User> findByIdIsIn(Collection<Long> usersId);
	public List <User> findByUsernameLike(String username);
}
