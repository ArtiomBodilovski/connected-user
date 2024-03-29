package com.app.ConnectedUsers.controller;


import com.app.ConnectedUsers.entity.User;
import com.app.ConnectedUsers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    /*
    * Sing up service
    * */
    @PostMapping("/signup")
    @CrossOrigin (origins = "http://localhost:4200")
    public User saveUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.saveUser(user);
    }

    /*
     * Login service
     * */
    @PostMapping("/login")
    @CrossOrigin (origins = "http://localhost:4200")
    public User UserLogin(@RequestBody User user) throws Exception {
        return userService.UserLogin(user);
    }

    /*
     * Logout service
     * */
    @PostMapping("/logout")
    @CrossOrigin (origins = "http://localhost:4200")
    public User UserLogout(@RequestBody User user) throws Exception {
        return userService.UserLogout(user);
    }

    /*
     * Get Data for DB service
     * */
    @GetMapping("/users")
    @CrossOrigin (origins = "http://localhost:4200")
    public List<User> getAllUser() throws ExecutionException, InterruptedException {
        return userService.getUserDetails();
    }


    //Not in use service
    @GetMapping("/users/{email}")
    @CrossOrigin (origins = "http://localhost:4200")
    public User getUser(@PathVariable String email) throws ExecutionException, InterruptedException {
        return userService.getUserDetailsByEmail(email);
    }


    @PutMapping("/users")
    @CrossOrigin (origins = "http://localhost:4200")
    public String updateUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.updateUser(user);
    }


    @DeleteMapping("/users/{email}")
    @CrossOrigin (origins = "http://localhost:4200")
    public String deleteUser(@PathVariable String email) throws ExecutionException, InterruptedException {
        return userService.deleteUser(email);
    }
}
