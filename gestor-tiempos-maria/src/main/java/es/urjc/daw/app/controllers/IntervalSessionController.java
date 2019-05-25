package es.urjc.daw.app.controllers;

import javax.servlet.http.HttpServletRequest;

import es.urjc.daw.app.interval.IntervalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IntervalSessionController {
	//Repositories
    
    @Autowired
    private IntervalRepository intervalRepository;
    
    private SesionController session;
    

}