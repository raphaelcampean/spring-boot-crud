package com.crud.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crud.demo.model.UserModel;
import com.crud.demo.record.AuthenticationDTO;
import com.crud.demo.record.LoginResponseDTO;
import com.crud.demo.service.TokenService;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    
}
