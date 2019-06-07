package es.urjc.daw.app.api;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.daw.app.category.Category;
import es.urjc.daw.app.category.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
	@Autowired private CategoryService service;

	@GetMapping("/")
	public Collection<Category> getCategories() {
		return service.findAll();
	}
	@GetMapping("/getCategory/{id}")
	public Category getCategoryrById(@PathVariable long id) {
		return service.findOne(id);
	}
	 
	@GetMapping("/getCategory")
	public Category getCategoryByName(@RequestParam String name) {
		return service.findOneByName(name);
	}
   
	@PostMapping("/createCategory")
	@ResponseStatus(HttpStatus.CREATED)
	public void createNewCategory() {
		System.out.println("*** Hemos entrado en el post de new category");
	}
	
	@PostMapping("/prueba")
	@ResponseStatus(HttpStatus.CREATED)
	public String pruebaPost() {
		System.out.println("*** Hemos entrado en el post");
		return "HA HECHO EL POST";
	}
} 
