package com.meli.interview.back.subscription.api.Services;

import com.meli.interview.back.subscription.api.models.User;
import com.meli.interview.back.subscription.api.models.forms.UserForm;
import org.springframework.stereotype.Service;

public interface UserService {

    User createUser(UserForm userForm);
    User findById(Long id);
}
