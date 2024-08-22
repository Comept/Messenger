package pet.project.Messenger.web.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(path="/api/chats",produces="application/json") 
@CrossOrigin(origins="http://tacocloud:8080")
public class ContactController {

}
