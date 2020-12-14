package io.github.jr.deveopers.eventlistener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jr.deveopers.eventlistener.jpa.User;
import io.github.jr.deveopers.eventlistener.jpa.UserRepository;
import org.hibernate.Hibernate;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class EventlistenerApplication {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(EventlistenerApplication.class, args);
    }

    @PostMapping("/user")
    public User insert(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User retrieve(@PathVariable("id") String id) {
        return userRepository.findById(id).orElseGet(() -> null);
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable("id") String id) throws JsonProcessingException {
        User user = userRepository.findById(id).orElseGet(() -> null);
        user.setName("TEST");
        userRepository.save(user);
        return user;
    }
}
