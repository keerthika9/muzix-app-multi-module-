package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class UserController {
    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
      ResponseEntity responseEntity;
      try {
        User savedUser = userService.saveUser(user);
        responseEntity = new ResponseEntity<String>("succesfullycreated", HttpStatus.CREATED);
      }
      catch(UserAlreadyExistsException ex) {

        responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        ex.printStackTrace();
      }
      return responseEntity;
      }

    @GetMapping("user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        System.out.println(id);
        User retrivedUser = userService.getUserById(id);
        return new ResponseEntity<User>(retrivedUser, HttpStatus.OK);
    }
}
