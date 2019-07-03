package es.urjc.daw.app.api;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

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
	public Event getUserById(@PathVariable long id) {
		return service.findOne(id);
	}
	
	@GetMapping("/get")
	public Event getEventByName(@RequestParam String name) {
		return service.findOneByName(name);
	}
	

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createNewEvent(@RequestBody Event name) {
		service.save(name);
	}
		
	/*@PostMapping("/set/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void setEventById(@PathVariable long id, @RequestParam String name) {
		Event event = new Event(name,"Wiki 2", "Date 2");
	     event.setIdEvent(id);
	      service.save(event);
	}*/
	@PostMapping("/set/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void setEventById(@PathVariable long id, @RequestBody Event event) {
	     event.setIdEvent(id);
	     service.save(event);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEventById(@PathVariable long id){
		service.delete(id);
	}
}
