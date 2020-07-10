package com.RestAPISecuritiToken.controller;

import com.RestAPISecuritiToken.model.User;
import com.RestAPISecuritiToken.security.Jwt.JwtTokenProvider;
import com.RestAPISecuritiToken.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    private final UserService userService;

    @Autowired
    public ViewController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.userService = userService;
    }
        @GetMapping("/main")
        public String index () {
        return "index";
        }
      public String page () {
          return "page";
      }

        @GetMapping("/login")
        public String login (){
        return "login";
        }




    @GetMapping("/registration")
    public String registration () {
        return "registration";
    }
    @PostMapping("/registration")
    public String save( User user) {
        userService.register(user);
        return "redirect:/login";
    }

}
