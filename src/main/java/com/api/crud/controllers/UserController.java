package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping("/create")
    public UserModel user(@RequestBody UserModel user){
        return userService.createUser(user);
    }
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getOneById(@PathVariable Long id){
        return userService.getOne(id);
    }
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request , Long id){
    return this.userService.updateByID(request, id);
    }
    @DeleteMapping (path = "/{id}")
    public String deleteById(@PathVariable ("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "User with id " + id + "deleted!";
        }else {
            return "Error, we have a problem and can´t delete user with id " + id ;
        }
    }
}
