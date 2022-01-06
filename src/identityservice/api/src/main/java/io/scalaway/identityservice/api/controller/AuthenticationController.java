package io.scalaway.identityservice.api.controller;

import io.scalaway.identityservice.api.dto.AccountProfileOutput;
import io.scalaway.identityservice.api.security.JwtUtils;
import io.scalaway.identityservice.application.port.api.AuthenticationEndpoint;
import io.scalaway.identityservice.application.usecase.authentication.command.LoginCommand;
import io.scalaway.identityservice.application.usecase.authentication.command.RegisterCommand;
import io.scalaway.identityservice.domain.Account;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1", produces="application/json")
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationEndpoint authenticationEndpoint;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthenticationController(
            AuthenticationEndpoint authenticationEndpoint,
            PasswordEncoder passwordEncoder,
            JwtUtils jwtUtils
    ){
        this.authenticationEndpoint = authenticationEndpoint;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public AccountProfileOutput register(@RequestBody RegisterCommand registerCommand){
        String encodedPassword = passwordEncoder.encode(registerCommand.getPassword());
        registerCommand.setPassword(encodedPassword);

        Account account = authenticationEndpoint.register(registerCommand);

        return AccountProfileOutput.fromDomain(account);
    }

    @PostMapping("/login")
    public ResponseEntity<AccountProfileOutput> login(@RequestBody LoginCommand loginCommand){
        Account account = authenticationEndpoint.login(loginCommand);
        if (account != null){
            String token = jwtUtils.generateAccessToken(account);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, token)
                    .body(AccountProfileOutput.fromDomain(account).updateToken(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
