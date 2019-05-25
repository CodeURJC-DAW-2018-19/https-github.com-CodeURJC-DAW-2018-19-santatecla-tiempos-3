package es.urjc.daw.app.controllers;

import es.urjc.daw.app.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategorySessionController {
    
    //Services
    @Autowired
    private CategoryService categoryService;

    private SesionController session;
    
}
