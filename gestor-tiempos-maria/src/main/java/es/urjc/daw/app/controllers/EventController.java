package es.urjc.daw.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.daw.app.event.Event;
import es.urjc.daw.app.event.EventService;

@Controller
public class EventController {
	@Autowired private  WebController webcontroller;	
	@Autowired private  EventService eventService;	
	@RequestMapping("/event/create") 
	public String createCategory(Model model, String name) {
		Event newEvent = new Event(name);
		eventService.save(newEvent);
		webcontroller.addUserToModel(model);
		return "redirect:/";
	} 
	@RequestMapping ("/event/delete/{idEvent}")
	public String deleteEvent(Model model,@PathVariable long idEvent) {
		eventService.delete(idEvent);
		webcontroller.addUserToModel(model);
		return "redirect:/";
	}
	@RequestMapping("/event/set/{idEvent}")
	public String setEvent(Model model, @PathVariable long idEvent,@RequestParam String name) {
		Event event = new Event(name);
		event.setIdEvent(idEvent);
        eventService.save(event);
		webcontroller.addUserToModel(model);
		return "redirect:/";
	} 
}
