package com.example.mobileappwspractise.service.serviceImplementation;

import com.example.mobileappwspractise.model.UpdateUserDetails;
import com.example.mobileappwspractise.model.UserDetails;
import com.example.mobileappwspractise.repository.UserRepository;
import com.example.mobileappwspractise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDetails> getAllUsers(){
        return userRepository.findAll();
    }

    public Object getUserById(String userId){
        Optional<UserDetails> userDetailsOptional = userRepository.findById(userId);
        if(userDetailsOptional.isPresent()){
            return userDetailsOptional.get();
        }
        return "ERORR !! User does not exist";
    }

    public String addUser(UserDetails userDetails){
        userRepository.save(userDetails);
        return "User Created";
    }

    public String updateUser(String userId, UpdateUserDetails userDetails){
        Optional<UserDetails> userRestOptional = userRepository.findById(userId);

        if(userRestOptional.isPresent()){
            userRestOptional.get().setFirstName(userDetails.getFirstName());
            userRestOptional.get().setLastName(userDetails.getLastName());
            userRepository.save(userRestOptional.get());
            return "Updated";
        }
        return "Error!! User does not exist yet";
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
