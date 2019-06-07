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

	@RequestMapping("/category/create") 
	public String createCategory(Model model, @RequestParam String categoryName) {
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
	}
	@RequestMapping("/category/set/{idCategory}")
	public String setCategory(Model model, @PathVariable long idCategory,@RequestParam String categoryName) {
		Category category = new Category(categoryName);
        category.setIdCategory(idCategory);
        categoryService.save(category);
		webcontroller.addUserToModel(model);
		return "redirect:/";
	}

}  
 