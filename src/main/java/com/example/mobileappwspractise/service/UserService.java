package com.example.mobileappwspractise.service;

import com.example.mobileappwspractise.model.UpdateUserDetails;
import com.example.mobileappwspractise.model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDetails> getAllUsers();

   Object getUserById(String userId);

    String addUser(UserDetails userDetails);

    String updateUser(String userId, UpdateUserDetails userDetails);

    void deleteUser(String userId);
}
