package pet.project.Messenger;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import pet.project.Messenger.entity.Chats;
import pet.project.Messenger.entity.User;
import pet.project.Messenger.repository.dao.UserDao;
import pet.project.Messenger.repository.dao.jdbc.UserRepo;

@Slf4j
@RequestMapping("/")
@Controller
public class controller {
	private final UserDao userDaoImpl;
	public controller( UserDao userDaoImpl) {
		super();
		this.userDaoImpl = userDaoImpl;
	}
	@GetMapping 
	public String home() {
		return "messenger.html"; 
	}
	@ModelAttribute
	public void addChatsToModel(Model model){
		List<Chats> chats = Arrays.asList(
				new Chats(1, "чат 1"),
				new Chats(2, "чат 2"),
				new Chats(3, "чат 3"),
				new Chats(4, "чат 4"),
				new Chats(5, "чат 5"),
				new Chats(6, "чат 3456")
				);
		model.addAttribute("chats", chats);
	}
}
