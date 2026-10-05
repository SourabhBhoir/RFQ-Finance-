package com.app.bidforge_security_learning.controller;

import com.app.bidforge_security_learning.entity.User;
import com.app.bidforge_security_learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    // REGISTER
    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(User user){
        userService.register(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(){

        return "login";
    }

    //LOGIN test1
//    @PostMapping("/login")
//    public String login(
//            @RequestParam String email,
//            @RequestParam String password
//    ){
//        boolean success = userService.login(email,password);
//
//        if(success) {
//            return "dashboard";
//        }
//
//        return "redirect:/login";
//    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
