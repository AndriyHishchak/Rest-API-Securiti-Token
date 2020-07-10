package com.RestAPISecuritiToken.rest;

import com.RestAPISecuritiToken.model.User;
import com.RestAPISecuritiToken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/register/")
public class Controller {

    UserService service;
    @Autowired
    public Controller(UserService service) {
        this.service = service;
    }

    @PostMapping("save")
    public User save(@RequestBody User user) {
        service.register(user);
        return user;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return "Delete Succsefully id - " + id;
    }
    @GetMapping("FullListIUsers")
    public List<User> getAll() {
        return service.getAll();
    }
}
