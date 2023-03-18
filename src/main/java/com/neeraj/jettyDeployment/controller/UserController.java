package com.neeraj.jettyDeployment.controller;

import com.neeraj.jettyDeployment.Service.UserService;
import com.neeraj.jettyDeployment.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HttpServletBean;

import java.util.List;

@RestController
//@WebServlet(urlPatterns = {"/user"})
@RequestMapping("/user")
public class UserController extends HttpServletBean {
    @Autowired
    private UserService userService;
    @GetMapping("/allUsers")
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = null;

        try{
            users = userService.getAllUsers();
        }
        catch (Exception ex){
            ex.getMessage();
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
