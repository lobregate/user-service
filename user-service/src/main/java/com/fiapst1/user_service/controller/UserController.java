package com.fiapst1.user_service.controller;

import com.fiapst1.user_service.domain.User;
import com.fiapst1.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user/{id}/", method = RequestMethod.GET)
    public Optional<User> findByUserId(@PathVariable Long id){
        return userRepository.findById(id);

    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user/new/default/{id}/", method = RequestMethod.GET)
    public User createNewDefaultUser(@PathVariable Long id){//remover depois, coloquei só pra testar o save no banco e dar carga de dados
        User user = new User(id,
                "default"+id+"@default.com",
                "Usuário Padrão "+id,
                "1234");

        return userRepository.save(user);
    }
}
