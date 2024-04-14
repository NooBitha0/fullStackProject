package com.example.fullStackProject.controller;


import com.example.fullStackProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.fullStackProject.vo.userVO;
import com.example.fullStackProject.dao.daoImpl;
@RestController
public class controllerClass {

    @Autowired
    private daoImpl daoImpl;



    @GetMapping("/users")
    public List<User> getAllUsers() {
        System.out.println("holllaaa");

        List<User> ans=daoImpl.getAllUsers();
        return ans;
    }

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody userVO user) {
        System.out.println("holllaaa");
        System.out.println(user);

        daoImpl.insertUser(user);

    }

}
