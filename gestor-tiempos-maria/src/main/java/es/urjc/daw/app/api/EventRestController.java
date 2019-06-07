package es.urjc.daw.app.api;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.daw.app.category.Category;
import es.urjc.daw.app.event.Event;
import es.urjc.daw.app.event.EventService;

@RestController
@RequestMapping("/api/events")
public class EventRestController {
	@Autowired private EventService service;

	@GetMapping("/")
	public Collection<Event> getEvents() {
		return service.findAll();
	}
	
	@GetMapping("/getEvent/{id}")
	public Event getUserById(@PathVariable long id) {
		return service.findOne(id);
	}
	
	@GetMapping("/getEvent")
	public Event getEventByName(@RequestParam String name) {
		return service.findOneByName(name);
	}
	//////////////////////////////////////////
	public String createNewEvent(@RequestParam String name) {
		Event newEvent = new Event(name);
		
		service.save(newEvent);
		return "redirect:/";
	}
		
	@PostMapping("/event/set/{id}")
	public String setEventById(@PathVariable long id, @RequestParam String name) {
		Event category = new Event(name);
	       category.setIdEvent(id);
	       service.save(category);
	       return "redirect:/";
	}

	@DeleteMapping("/event/delete/{id}")
	public String deleteEventById(@PathVariable long id){
		service.delete(id);
		return "redirect:/";
	}
}
