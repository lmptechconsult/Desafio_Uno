package com.previred.periods.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// TODO: Auto-generated Javadoc
/**
 * Home redirection to swagger api documentation.
 */
@Controller
public class HomeController {
	
	
    /**
     * Redirect swagger.
     *
     * @return the string
     */
    @GetMapping(value = {"/",""})
    public String redirectSwagger() {
        return "redirect:swagger-ui/";
    }

}
