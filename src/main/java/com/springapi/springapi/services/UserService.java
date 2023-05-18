package com.springapi.springapi.services;

import com.springapi.springapi.models.User;
import com.springapi.springapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Add User
    public User addUser(User user){
        return userRepository.save(user);
    }

    // Get user by id
    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    //Delete user
    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "User Removed";
    }

    //Update User
    public User updateUser(User user){
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        assert existingUser != null;
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone_number(user.getPhone_number());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

}
