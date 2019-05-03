package es.urjc.daw.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import es.urjc.daw.app.user.UserComponent;


@Controller
public class WebController {
	
	@Autowired private UserComponent userComponent;
	
	@ModelAttribute
	public void addUserToModel(Model model) {
		boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
		if(logged) {
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
			model.addAttribute("username",userComponent.getLoggedUser().getEmail());
		}
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
