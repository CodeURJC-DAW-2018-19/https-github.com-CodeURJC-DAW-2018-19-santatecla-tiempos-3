package es.urjc.daw.app.api;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/get/{id}")
	public Event getEventById(@PathVariable long id) {
		return service.findOne(id);
	}
	
	@GetMapping("/get")
	public Event getEventByName(@RequestParam String name) {
		return service.findOneByName(name);
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createNewEvent(@RequestParam Event event) {
		service.save(event);
	}
	
	/*@PostMapping("/set/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void setEventById(@PathVariable long id, @RequestParam Category category) {
		Event event = new Event(categoryName);
        event.setIdEvent(id);
        service.save(event);
	}*/

	@DeleteMapping("/delete/{id}")
	public void deleteEventById(@PathVariable long id){
		service.delete(id);
	}
}
