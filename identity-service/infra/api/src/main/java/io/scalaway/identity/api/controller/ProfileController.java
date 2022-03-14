package io.scalaway.identity.api.controller;

import io.scalaway.identity.api.dto.AccountProfileOutput;
import io.scalaway.identity.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    @GetMapping("/me")
    public ResponseEntity<AccountProfileOutput> getMyProfile(@AuthenticationPrincipal Account user){
        return new ResponseEntity<>(
                AccountProfileOutput.fromDomain(user),
                HttpStatus.OK
        );
    }
}
