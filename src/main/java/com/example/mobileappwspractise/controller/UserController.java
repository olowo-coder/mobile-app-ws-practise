package com.example.mobileappwspractise.controller;

import com.example.mobileappwspractise.exceptions.UserServiceException;
import com.example.mobileappwspractise.model.UpdateUserDetails;
import com.example.mobileappwspractise.model.UserDetails;
import com.example.mobileappwspractise.service.UserService;
import com.example.mobileappwspractise.service.serviceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort){
        return "get users was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<UserDetails> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{userId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getUser(@PathVariable String userId){
            return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/error",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> displayError(){
//        String error = null;
//        int check = error.length();
        if(true) throw new UserServiceException("A user exception is displayed");
        return ResponseEntity.ok(userService.getUserById("error"));
    }


    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }

    )
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDetails userDetails){
        String response = userService.addUser(userDetails);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PutMapping(value = "/{userId}",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }

    )
    public ResponseEntity<?> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetails updateUserDetails){
        String response = userService.updateUser(userId, updateUserDetails);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
