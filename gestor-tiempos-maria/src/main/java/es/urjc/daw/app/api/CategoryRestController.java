package es.urjc.daw.app.api;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
