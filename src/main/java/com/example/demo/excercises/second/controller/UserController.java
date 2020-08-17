package com.example.demo.excercises.second.controller;

import com.example.demo.excercises.second.model.User;
import com.example.demo.excercises.second.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseBody
//    @RequestMapping("/users")
    @GetMapping("/users")
    public String getAll() {
        List<User> userList = userRepository.findAll();

        return userList.stream()
                .map(User::toString)
                .collect(Collectors.joining("<br/>"));
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PostMapping("/add")
    public String add(@RequestParam(name = "firstName"/*, required = false, defaultValue = "Anonim"*/) String imie,
                      @RequestParam String lastName,
                      @RequestParam Integer age) {
        if (imie != null && imie.equals("")) {
            return "redirect:/error.html";
        } else {
            User user = new User(imie, lastName, age);
            userRepository.save(user);
            return "redirect:/success.html";
        }
    }
}
