package io.scalaway.identity.api.controller;

import io.scalaway.identity.api.dto.AccountOutput;
import io.scalaway.identity.application.port.api.AccountEndpoint;
import io.scalaway.identity.application.usecase.authentication.command.RegisterCommand;
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
