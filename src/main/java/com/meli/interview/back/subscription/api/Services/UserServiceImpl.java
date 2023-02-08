package com.meli.interview.back.subscription.api.Services;

import com.meli.interview.back.subscription.api.dao.GenericDAO;
import com.meli.interview.back.subscription.api.models.User;
import com.meli.interview.back.subscription.api.models.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.security.Principal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GenericDAO<User> userDAO;


    @Override
    public User createUser(UserForm userForm) {
        return userDAO.create(User.builder().name(userForm.getName()).build());
    }

    @Override
    public User findById(Long id) {
        return userDAO.findOne(id);
    }

}
