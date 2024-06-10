package com.fiapst1.user_service.controller;

import com.fiapst1.user_service.domain.User;
import com.fiapst1.user_service.dtos.LoginDto;
import com.fiapst1.user_service.dtos.TokenDto;
import com.fiapst1.user_service.dtos.UserDto;
import com.fiapst1.user_service.repository.UserRepository;
import com.fiapst1.user_service.security.CustomUserDetailsService;
import com.fiapst1.user_service.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.fiapst1.user_service.security.SecurityConfig.passwordEncoder;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    JwtService jwtService;

    @RequestMapping(value = "/user/healthcheck", method = RequestMethod.GET)
    public ResponseEntity healthCheck(){
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


    @RequestMapping(value = "/user/{id}/", method = RequestMethod.GET)
    public Optional<User> findByUserId(@PathVariable Long id){
        return userRepository.findById(id);

    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginDto data) {
        try {
            customUserDetailsService.verifyUserCredentials(data);
            String token = jwtService.generateToken(data.getEmail());
            TokenDto tokenDto = new TokenDto();
            tokenDto.setToken(token);
            return new ResponseEntity<>(tokenDto, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity createNewUser(@RequestBody UserDto data){
        try {
            User user = new User();
            user.setNome(data.getNome());
            user.setEmail(data.getEmail());
            user.setSenha(passwordEncoder().encode(data.getSenha()));
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
