package es.urjc.daw.app.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	//Aqui en el postman hay que meterle bien la forma de crear el user
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public User createBook(@RequestBody User user) {
		System.out.println("*********Ha entrado");
		service.save(user);
		return user;
	}
	
	@PostMapping("/prueba")
	@ResponseStatus(HttpStatus.CREATED)
	public String prueba(@RequestBody String prueba) {
		System.out.println("*********Ha entrado");
		return prueba;
	}
	
	//Por implementar: deleteUser
	
	//Por implementar: updateUser (buscamos por email, por nombre ???)
	
	//Por implementar: searchUser (by name)
	
	
}
