package com.sample.sb3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewsController {
    @RequestMapping(method = RequestMethod.GET, value = {
            "/",
            "/index",
            "/bai-etl"
    })
    public String index(Model model) {
        System.setProperty("App-Version", this.getClass().getPackage().getImplementationVersion() == null ? "SNAPSHOT" :
                this.getClass().getPackage().getImplementationVersion());
        return "Index";
    }

    @RequestMapping(value = "views/sample")
    public String sample(Model model) {
        model.addAttribute("title", "Custom Title");
        return "views/Sample";
    }
}
