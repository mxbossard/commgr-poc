package fr.mby.commgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foo")
public class FooController {

    @RequestMapping("")
    public String index() {
        return "foo";
    }

}