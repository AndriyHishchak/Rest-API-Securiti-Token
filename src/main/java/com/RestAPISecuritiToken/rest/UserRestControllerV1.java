package com.RestAPISecuritiToken.rest;

import com.RestAPISecuritiToken.DTO.UserDTO;
import com.RestAPISecuritiToken.model.User;
import com.RestAPISecuritiToken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users/")
public class UserRestControllerV1 {
    private UserService userService;
    @Autowired
    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> getUserId(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserDTO result = UserDTO.fromUser(user);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "Delete Succsefully id - " + id;
    }
    @GetMapping("full")
    public List<User> getAll() {
        return userService.getAll();
    }
}
