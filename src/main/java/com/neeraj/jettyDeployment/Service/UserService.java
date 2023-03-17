package com.neeraj.jettyDeployment.Service;

import com.neeraj.jettyDeployment.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public  User getUserById(int id);
    public User addOrUpdateUser(User user);
    public User deleteUser(int id) throws Exception;

}
