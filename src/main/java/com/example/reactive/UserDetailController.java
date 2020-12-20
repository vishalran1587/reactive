package com.example.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserDetailController {
    @Autowired
    UserDetailRepository userDetailRepo;

    @PostMapping("/user/{name}")
    public Mono<UserDetail> createUser(@PathVariable("name") String name) {
        UserDetail user = new UserDetail(name, name + "@gmail.com");
        return userDetailRepo.save(user);
    }

    @GetMapping("/user")
    public Flux<UserDetail> getAllUsers() {
        return userDetailRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public Mono<UserDetail> getById(@PathVariable("id") Long id) {
        return userDetailRepo.findById(id);
    }
}
