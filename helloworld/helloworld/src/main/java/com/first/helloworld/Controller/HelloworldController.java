package com.first.helloworld.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
@RestController
@RequestMapping("/api")
public class HelloworldController {

    @GetMapping("/hello")
    public User helloWorld() {

        return new User("Hello, World!");
    }
}


