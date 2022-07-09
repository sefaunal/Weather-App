package com.sefaunal.WeatherApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    @GetMapping("/")
    public RedirectView redirectHome(){
        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("user", null);
        return "HomePage";
    }
}
