package es.urjc.daw.app.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.daw.app.interval.Interval;
import es.urjc.daw.app.interval.IntervalService;

@RestController
@RequestMapping("/api/intervals")
public class IntervalRestController {
	@Autowired private IntervalService service;
	//Peta porque hace una recursión infinita
	@GetMapping("/")
	public Collection <Interval> getIntervals() {
		Collection <Interval> intervalos = service.findAll();
		System.out.println (intervalos);
		return intervalos;
	}
}
