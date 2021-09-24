package com.exam.DAO;

import com.exam.model.User;
import com.exam.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;
public interface UserService {


    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //Getting user
    public User getUser(String username);

    //Delete user by id
    public void deteleUser(Long userId);

    //update user
//    public  User updateUser(User user, String username);

}
