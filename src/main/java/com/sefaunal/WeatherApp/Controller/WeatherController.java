package com.sefaunal.WeatherApp.Controller;

import com.sefaunal.WeatherApp.Model.User;
import com.sefaunal.WeatherApp.Model.Weather;
import com.sefaunal.WeatherApp.Repository.UserRepository;
import com.sefaunal.WeatherApp.Service.UserService;
import com.sefaunal.WeatherApp.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WeatherController {
    @Autowired
    UserService userService;

    @Autowired
    WeatherService weatherService;

    @PostMapping("/home/weather/save")
    public @ResponseBody Boolean createWeather(@RequestBody Weather weather, Principal principal){
        User user = userService.findByUserMail(principal.getName());
        try {
            weather.setUser(user);
            user.getWeatherList().add(weather);
            userService.createUser(user);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @GetMapping("/home/weatherRecords")
    public ModelAndView weatherRecords(Principal principal, Model model){
        User user = userService.findByUserMail(principal.getName());

        List<Weather> weatherList = new ArrayList<>();
        weatherList = weatherService.findWeatherByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("weatherList", weatherList);

        return new ModelAndView("WeatherList");
    }

    @GetMapping("/home/weatherRecords/delete")
    public RedirectView deleteWeather(Principal principal, @RequestParam Long weatherID){
        User user = userService.findByUserMail(principal.getName());
        if (weatherService.findByWeatherID(weatherID).getUser() == user){
            weatherService.deleteByWeatherID(weatherID);
            return new RedirectView("/home/weatherRecords");
        }
        else{
            return new RedirectView("/error403");
        }
    }
}
