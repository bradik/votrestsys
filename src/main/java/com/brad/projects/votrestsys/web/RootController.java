package com.brad.projects.votrestsys.web;

import com.brad.projects.votrestsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Brad on 27.08.2017.
 */
@Controller
public class RootController {
    @Autowired
    private UserService service;
}
