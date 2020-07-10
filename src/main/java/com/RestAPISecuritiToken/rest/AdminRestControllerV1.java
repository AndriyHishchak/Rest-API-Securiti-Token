package com.RestAPISecuritiToken.rest;

import com.RestAPISecuritiToken.DTO.AdminUserDTO;
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
@RequestMapping(value = "/api/admin/")
public class AdminRestControllerV1 {
    private UserService userService;
@Autowired
    public AdminRestControllerV1(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "Delete Succsefully id - " + id;
    }
    @GetMapping("FullListIUsers")
    public List<User> getAll() {
        return userService.getAll();
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<AdminUserDTO> getUserId(@PathVariable(name = "id") Long id) {
    User user = userService.findById(id);

    if(user == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    AdminUserDTO result = AdminUserDTO.fromUser(user);
    return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
