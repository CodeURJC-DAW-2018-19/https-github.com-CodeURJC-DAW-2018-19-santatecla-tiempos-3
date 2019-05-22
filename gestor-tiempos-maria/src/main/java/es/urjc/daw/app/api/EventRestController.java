package es.urjc.daw.app.api;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
