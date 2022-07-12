package com.sefaunal.WeatherApp.Repository;

import com.sefaunal.WeatherApp.Model.User;
import com.sefaunal.WeatherApp.Model.Weather;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    List<Weather> findByUser(User user);

    Page<Weather> findAllByUser(User user, Pageable pageable);

}
