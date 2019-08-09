package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.UserAlreadyExistsException;
import com.stackroute.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

      this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user)throws UserAlreadyExistsException {
      if(userRepository.existsById(user.getId())){
        throw new UserAlreadyExistsException(("user already exists"));
      }
        User savedUser=userRepository.save(user);
      if(savedUser==null){
        throw new UserAlreadyExistsException("user already exists");
      }
        return savedUser;
    }

    @Override
    public User getUserById(int id) {
        User retrievedUser=userRepository.findById(id).get();
        return retrievedUser;
    }

}
