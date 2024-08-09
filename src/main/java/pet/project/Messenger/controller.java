package pet.project.Messenger;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
import pet.project.Messenger.repository.dao.jdbc.UserService;

@Slf4j
@RequestMapping("/m")
@Controller
public class controller {
	

	private final UserService userService;
	
	
	public controller(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping 
	public String home() {
		
		System.out.print(userService.findjjhjj("ali1").getEmail());
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
