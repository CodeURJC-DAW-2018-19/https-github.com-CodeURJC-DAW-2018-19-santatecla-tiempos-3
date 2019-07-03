package es.urjc.daw.app.api;


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

import java.util.List;
import es.urjc.daw.app.interval.Interval;
import es.urjc.daw.app.interval.IntervalService;

@RestController
@RequestMapping("/api/intervals")
public class IntervalRestController {
	@Autowired private IntervalService service;
	//Peta porque hace una recursión infinita
	@GetMapping("/")
	public List <Interval> getIntervals() {
		List <Interval> intervalos = service.findAll();
		System.out.println (intervalos);
		System.out.println ("!!!!");
		return intervalos;
	}
	
	@GetMapping("/get/{id}")
	public Interval getIntervalById(@PathVariable long id) {
		return service.findOne(id);
	}
	
	@GetMapping("/get")
	public Interval getIntervalByName(@RequestParam String name) {
		return service.findOneByName(name);
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createNewInterval(@PathVariable long id, @RequestParam String name,@RequestParam String startdate,@RequestParam String enddate) {
		Interval newInterval = new Interval(name,startdate,enddate);
		service.save(newInterval);
	}
	/*@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createNewInterval(@RequestBody Interval interval) {
		service.save(interval);
	}*/
		
	@PostMapping("/set/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void setIntervalById(@PathVariable long id, @RequestParam String name,@RequestParam String startdate,@RequestParam String enddate) {
		Interval interval = new Interval(name,startdate,enddate);
	       interval.setIdInterval(id);
	       service.save(interval);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteIntervalById(@PathVariable long id){
		service.delete(id);
	}
	
}
