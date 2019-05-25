package es.urjc.daw.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.urjc.daw.app.category.CategoryRepository;
import es.urjc.daw.app.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class EventSessionController {
    //Repositories

    @Autowired
    private EventService eventService;
    @Autowired
    CategoryRepository categoryRepository;
    private SesionController session;


    
}