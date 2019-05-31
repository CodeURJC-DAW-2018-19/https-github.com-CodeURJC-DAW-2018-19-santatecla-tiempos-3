package es.urjc.daw.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import es.urjc.daw.app.category.Category;
import es.urjc.daw.app.category.CategoryService;
import es.urjc.daw.app.event.Event;
import es.urjc.daw.app.event.EventService;
import es.urjc.daw.app.interval.Interval;
import es.urjc.daw.app.interval.IntervalService;
import es.urjc.daw.app.user.UserComponent;


@Controller
public class WebController {
	
	@Autowired private UserComponent userComponent;
	@Autowired private  CategoryService categoryService;	
	@Autowired private  EventService eventService;	
	@Autowired private  IntervalService intervalService;	

	 
	@ModelAttribute
	public void addUserToModel(Model model) {
		boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
		if(logged) {
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
			model.addAttribute("username",userComponent.getLoggedUser().getEmail());
		}
	}
	@ModelAttribute
	public void addElementsToModel(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categorias", categories);
		List<Event> events = eventService.findAll();
		model.addAttribute("eventos", events);
		List<Interval> intervals = intervalService.findAll();
		model.addAttribute("intervalos", intervals);
	}
	
	@GetMapping("/")
	public String root(Model model) {
		return "home";
	}
	@GetMapping("/home")
	public String root2(Model model) {
		return "home";
	}
	

}
