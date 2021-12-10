package com.example.servingwebcontent;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "registration";
    }

    @GetMapping("/login")
    public String login(@RequestParam(name = "name", required = false, defaultValue = "User") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @PostMapping("/registration")
    public @ResponseBody
    String addNewUser(@RequestParam String userName,
                      @RequestParam String email,
                      @RequestParam String phoneNumber,
                      @RequestParam String jobName,
                      @RequestParam String password) {

        User user = new User(userName, email, phoneNumber, jobName, password);
		userRepo.save(user);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

}
