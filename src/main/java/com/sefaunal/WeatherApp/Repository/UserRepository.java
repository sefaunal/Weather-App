package com.sefaunal.WeatherApp.Repository;

import com.sefaunal.WeatherApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserMail(String mail);
}
