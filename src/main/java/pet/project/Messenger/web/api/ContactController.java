package pet.project.Messenger.web.api;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pet.project.Messenger.dto.ChatDto;

@RestController 
@RequestMapping(path="/api/chats/{id}",produces="application/json") 
public class ContactController {
	
	@GetMapping(params="recent")
	public List<ChatDto>  getChat(@PathVariable("id") Long chatId,@RequestParam("recent") int recent){
		PageRequest page = PageRequest.of(
				recent, 12, Sort.by("createdAt").descending());
		try{	

		}
		catch(Exception ex){
				System.out.println(ex);
		}
		return (List<ChatDto>) new Object();
		
	}

}
