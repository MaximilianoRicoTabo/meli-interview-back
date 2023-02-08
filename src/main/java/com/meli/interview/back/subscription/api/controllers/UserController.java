package com.meli.interview.back.subscription.api.controllers;

import com.meli.interview.back.subscription.api.Services.UserService;
import com.meli.interview.back.subscription.api.models.Subscription;
import com.meli.interview.back.subscription.api.models.User;
import com.meli.interview.back.subscription.api.models.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired UserService userService;

    @PostMapping("/create")
    public @ResponseBody HttpStatus createUser(UserForm userForm) {
        User user = userService.createUser(userForm);
        return user != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @GetMapping("/get")
    public @ResponseBody ResponseEntity<User> get(Long  id) {
        User user = userService.findById(id);
        HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
            return new ResponseEntity<User>(user, status );
    }

    @GetMapping("/{user}/getUserSubscriptions")
    public @ResponseBody ResponseEntity<List<Subscription>> getUserSubscriptions(@PathVariable User  user) {
        return new ResponseEntity<List<Subscription>>(user.getSubscriptions(), HttpStatus.OK);
    }
}
