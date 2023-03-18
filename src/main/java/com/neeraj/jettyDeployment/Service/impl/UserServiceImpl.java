package com.neeraj.jettyDeployment.Service.impl;

import com.neeraj.jettyDeployment.Service.UserService;
import com.neeraj.jettyDeployment.entity.User;
import com.neeraj.jettyDeployment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public List<User> getAllUsers() {
        System.out.println(1);
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User addOrUpdateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User deleteUser(int id) throws Exception {
        User deletedUser = null;
        try{
            deletedUser = userRepo.findById(id).orElse(null);
            if(deletedUser == null)
                throw new Exception("user not available");
            else{
                userRepo.deleteById(id);
            }
        }
        catch(Exception ex) { throw ex;}
        return deletedUser;
    }
}
