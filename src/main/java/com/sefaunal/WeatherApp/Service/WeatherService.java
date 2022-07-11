package com.sefaunal.WeatherApp.Service;

import com.sefaunal.WeatherApp.Model.Weather;
import com.sefaunal.WeatherApp.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    public void saveWeather(Weather weather) {
        weatherRepository.save(weather);
    }
}
