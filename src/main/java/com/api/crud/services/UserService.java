package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    public UserModel createUser(UserModel user){
        return userRepository.save(user);
    }
    public Optional<UserModel> getOne(Long id){
        return userRepository.findById(id);
    }
    /*public Optional<UserModel> updateByID(UserModel request, Long id ){
    return userRepository.
    }*/

}
