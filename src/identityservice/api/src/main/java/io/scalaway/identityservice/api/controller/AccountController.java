package io.scalaway.identityservice.api.controller;

import io.scalaway.identityservice.api.dto.AccountOutput;
import io.scalaway.identityservice.application.port.api.AccountEndpoint;
import io.scalaway.identityservice.application.usecase.authentication.command.RegisterCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/accounts", produces="application/json")
public class AccountController {

    private final AccountEndpoint accountEndpoint;

    public AccountController(
            AccountEndpoint accountEndpoint
    ){
        this.accountEndpoint = accountEndpoint;
    }

    @PostMapping
    public AccountOutput create(@RequestBody RegisterCommand registerCommand){
        return null;
    }

    @GetMapping
    public List<AccountOutput> getAll(@RequestBody RegisterCommand registerCommand){
        return null;
    }

    @GetMapping("{id}")
    public AccountOutput getById(@RequestBody RegisterCommand registerCommand){
        return null;
    }

    @DeleteMapping
    public ResponseEntity deleteById(@RequestBody RegisterCommand registerCommand){
        return null;
    }


}
