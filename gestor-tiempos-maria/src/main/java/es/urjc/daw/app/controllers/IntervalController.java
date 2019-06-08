package es.urjc.daw.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.daw.app.event.Event;
import es.urjc.daw.app.interval.Interval;
import es.urjc.daw.app.interval.IntervalService;

@Controller
public class IntervalController {
	@Autowired private  WebController webcontroller;	
	@Autowired private  IntervalService intervalService;	
	@RequestMapping("/interval/create") 
	public String createInterval(Model model, @RequestParam String intervalName,@RequestParam String startdate, @RequestParam String enddate,@RequestParam Long parentId ) {
		Interval newInterval = new Interval(intervalName, startdate, enddate);
        if (parentId!=-1) {
    	Interval padre = intervalService.findByIdInterval(parentId);
    	//newInterval.setParent(padre);
    	}
        intervalService.save(newInterval);
		webcontroller.addUserToModel(model);
		return "redirect:/";
	} 
	@RequestMapping ("/interval/delete/{idEvent}")
	public String deleteEvent(Model model,@PathVariable long idEvent) {
		intervalService.delete(idEvent);
		webcontroller.addUserToModel(model);
		return "redirect:/";
	}
	@RequestMapping("/interval/set/{idEvent}")
	public String setEvent(Model model, @PathVariable long idInterval,@RequestParam String intervalName,@RequestParam String startdate, @RequestParam String enddate,@RequestParam Long parentId ) {
		Interval newInterval = new Interval(intervalName, startdate, enddate);
        newInterval.setIdInterval(idInterval);
        if (parentId!=-1) { 
        	Interval padre = intervalService.findByIdInterval(parentId);
        	//newInterval.setParent(padre);
    	} 
		intervalService.save(newInterval);
		webcontroller.addUserToModel(model);
		return "redirect:/";
	} 
}
