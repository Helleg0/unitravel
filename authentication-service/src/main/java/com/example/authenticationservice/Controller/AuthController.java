package com.example.authenticationservice.Controller;

import com.example.authenticationservice.Service.LoginServicio;
import com.example.authenticationservice.dto.Login;
import com.example.authenticationservice.dto.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/signin")
    public ResponseEntity<TokenDTO> login(@RequestBody Login loginDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new Respuesta<>("Login correcto",  LoginServicio. );
    }

}
