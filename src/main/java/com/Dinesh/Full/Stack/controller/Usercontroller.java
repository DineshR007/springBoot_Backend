package com.Dinesh.Full.Stack.controller;

import com.Dinesh.Full.Stack.exception.UserNotFoundExeception;
import com.Dinesh.Full.Stack.module.User;
import com.Dinesh.Full.Stack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class Usercontroller {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user")
    User newUser (@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundExeception(id));
    }
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(()-> new UserNotFoundExeception(id));
    }
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
    if(!userRepository.existsById(id)){
    throw new UserNotFoundExeception(id);
}
    userRepository.deleteById(id);
    return "User with id "+id+" has been deleted successfully";
}
}