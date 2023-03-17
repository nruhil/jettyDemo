package com.neeraj.jettyDeployment.repo;
import com.neeraj.jettyDeployment.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{

}
