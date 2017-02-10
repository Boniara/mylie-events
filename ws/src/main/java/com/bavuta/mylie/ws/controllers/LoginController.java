package com.bavuta.mylie.ws.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by bogdan on 12/19/2016.
 */

@RestController
public class LoginController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getHomePage() {
        ModelAndView homePage = new ModelAndView("home");
        return homePage;
    }
}
