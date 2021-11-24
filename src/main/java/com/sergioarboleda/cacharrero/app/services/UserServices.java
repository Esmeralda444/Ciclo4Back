package com.sergioarboleda.cacharrero.app.services;

import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author epereira
 */
@Service
public class UserServices {
    @Autowired
    private UserRepository repository;

    /**
     * @return
     */
    public List<User> getAll() {
        return repository.getAll();
    }

    public User save(User user) {
        if (user.getName() != null && user.getEmail() != null && user.getPassword() != null) {
            return repository.save(user);
        } else {
            return user;
        }
    }

    public boolean verifyEmail(String email){
        Optional<User> user = repository.verifyEmail(email);
        if (user.isPresent()){
            return true;
        } else {
            return false;
        }
    }

    public User byEmailPass(String email, String pass){
        Optional<User> user = repository.byEmailPass(email, pass);
        User error =new User(null, email, pass,"NO DEFINIDO");
        if (user.isPresent()){
            return user.get();
        } else {
            return error;
        }

    }
}
