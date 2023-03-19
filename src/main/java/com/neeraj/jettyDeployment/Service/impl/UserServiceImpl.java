package com.neeraj.jettyDeployment.Service.impl;

import com.neeraj.jettyDeployment.Service.UserService;
import com.neeraj.jettyDeployment.entity.User;
import com.neeraj.jettyDeployment.repo.UserRepo;
import com.neeraj.jettyDeployment.repo.UserRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.inject.Inject;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepoImpl userRepoImpl;
    /*@Inject
    public  UserServiceImpl( UserRepo userRepo){
        this.userRepo = userRepo;
    }*/
    public  UserServiceImpl(){}
    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepoImpl.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepoImpl.findById(id).orElse(null);
    }

    @Override
    public User addOrUpdateUser(User user) {
        return userRepoImpl.save(user);
    }

    @Override
    public User deleteUser(int id) throws Exception {
        User deletedUser = null;
        try{
            deletedUser = userRepoImpl.findById(id).orElse(null);
            if(deletedUser == null)
                throw new Exception("user not available");
            else{
                userRepoImpl.deleteById(id);
            }
        }
        catch(Exception ex) { throw ex;}
        return deletedUser;
    }

    public UserRepoImpl getUserRepoImpl() {
        return userRepoImpl;
    }

    public void setUserRepoImpl(UserRepoImpl userRepoImpl) {
        this.userRepoImpl = userRepoImpl;
    }
}
