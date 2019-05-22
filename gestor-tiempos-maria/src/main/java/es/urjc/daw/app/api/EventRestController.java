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
	
	@GetMapping("/getEvent/{id}")
	public Event getUserById(@PathVariable long id) {
		return service.findOne(id);
	}
	
	@GetMapping("/getCategory")
	public Event getEventByName(@RequestParam String name) {
		return service.findOneByName(name);
	}
}
