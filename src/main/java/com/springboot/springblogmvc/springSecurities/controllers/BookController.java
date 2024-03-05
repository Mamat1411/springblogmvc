package com.springboot.springblogmvc.springSecurities.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/books")
public class BookController {
    
    @GetMapping("/")
    public ModelAndView getAllBooks() {
        ModelAndView view = new ModelAndView("springsecurities/books/index");
        return view;
    }

}
