package com.exam.Controller;

import com.exam.DAO.UserService;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();

        //Making object of role
        Role role = new Role();
        role.setRoleName("NORMAL");
        role.setRoleId(45L);

        //Making object of user role
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        // Adding the user role into our set

        roles.add(userRole);

        return this.userService.createUser(user, roles);
    }
    //Fetching Users
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){

        return this.userService.getUser(username);
    }

    //Deleting User
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deteleUser(userId);
    }

      //Update User
//    @PutMapping("/update/{username}")
//     public User updateUser(@RequestBody User user,@PathVariable("username") String userName) throws Exception {
//        return this.userService.updateUser(user,userName);
//    }
}

























