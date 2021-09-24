package com.exam.DAO.Implementation;

import com.exam.DAO.UserService;
import com.exam.Repository.RoleRepository;
import com.exam.Repository.UserRepository;
import com.exam.model.User;
import com.exam.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {


        User local=this.userRepository.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println("User is already there!!");
            throw new Exception("User ALready Present");
        }else{
            // user create
            for(UserRole ur: userRoles)
            {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local=this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deteleUser(Long userId) {
        this.userRepository.deleteById(userId);
    }




}
































