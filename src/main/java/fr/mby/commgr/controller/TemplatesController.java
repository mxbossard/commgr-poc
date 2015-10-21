package fr.mby.commgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fragments")
public class TemplatesController {

    @RequestMapping("/test")
    public String season() {
        return "fragments/test";
    }

}