package es.urjc.daw.app.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import java.util.Collection;

import es.urjc.daw.app.user.User;
import es.urjc.daw.app.user.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	@Autowired private UserService service;
	
	@GetMapping("/")
	public Collection<User> getUsers() {
		return service.findAll();
	}
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable long id) {
		return service.findOneById(id);
	}
	
	@GetMapping("/get")
	public User getUserByName(@RequestParam String name) {
		return service.findOne(name);
	}
	
	//Aqui en el postman hay que meterle bien la forma de crear el user
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody User user) {
		service.save(user);
	}
}
