package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;

public interface UserService {
    public User saveUser(User user)throws UserAlreadyExistsException;

    public User getUserById(int id);

}
