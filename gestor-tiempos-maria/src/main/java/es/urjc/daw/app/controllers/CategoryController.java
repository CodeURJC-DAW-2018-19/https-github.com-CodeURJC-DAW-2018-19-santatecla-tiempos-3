package es.urjc.daw.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.urjc.daw.app.category.Category;
import es.urjc.daw.app.category.CategoryService;

@Controller
public class CategoryController {
	@Autowired private  WebController webcontroller;	
	@Autowired private  CategoryService categoryService;	

	/*@RequestMapping("/category/create") 
	public String createCategory(Model model, @RequestParam String categoryName) {
		System.out.println("!!!!!");
		Category newCategory = new Category(categoryName);
		
		System.out.println(categoryName);
		categoryService.save(newCategory);
		webcontroller.addUserToModel(model);
		return "redirect:/";
	} 
	@RequestMapping ("/category/delete/{idCategory}")
	public String deleteCategory(Model model,@PathVariable long idCategory) {
		categoryService.delete(idCategory);
		webcontroller.addUserToModel(model);
		return "redirect:/";
	}*/
	/*@RequestMapping("/category/set/{idCategory}")
	public String setCategory(Model model, @PathVariable long idCategory,@RequestParam String categoryName) {
		Category category = new Category(categoryName);
        category.setIdCategory(idCategory);
        categoryService.save(category);
		webcontroller.addUserToModel(model);
		return "redirect:/";
	}
	@RequestMapping(value = "/category/delete/{idCategory}", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePath() {
	    return "redirect:/";
	}*/
	 ///////
	//CATEGORY	

	@PostMapping("/category/create")
	public String createNewCategory(@RequestParam String name) {
		Category newCategory = new Category(name);
		
		categoryService.save(newCategory);
		return "redirect:/";
	}
		
	@PostMapping("/category/set/{id}")
	public String setCategoryById(@PathVariable long id, @RequestParam String name) {
		Category category = new Category(name);
	       category.setIdCategory(id);
	       categoryService.save(category);
	       return "redirect:/";
	}

	@DeleteMapping("/category/delete/{id}")
	public String deleteCategoryById(@PathVariable long id){
		categoryService.delete(id);
		return "redirect:/";
	}

/*
	//event

	@PostMapping("/create")
		@ResponseStatus(HttpStatus.CREATED)
		public void createNewEvent(@RequestParam Event event) {
			service.save(event);
		}
		
		@PostMapping("/set/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public void setEventById(@PathVariable long id, @RequestParam Category category) {
			Event event = new Event(categoryName);
	        event.setIdEvent(id);
	        service.save(event);
		}

		@DeleteMapping("/delete/{id}")
		public void deleteEventById(@PathVariable long id){
			service.delete(id);
		}

	//interval
		@PostMapping("/create")
		@ResponseStatus(HttpStatus.CREATED)
		public void createNewInterval(@RequestParam Interval interval) {
			service.save(interval);
		}
		
		@PostMapping("/set/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public void setIntervalyById(@PathVariable long id, @RequestParam String name) {
			Interval interval = new Interval(name);
	        interval.setIdInterval(id);
	        service.save(category);
		}

		@DeleteMapping("/delete/{id}")
		public void deleteIntervalById(@PathVariable long id){
			service.delete(id);
		}*/
}  
 