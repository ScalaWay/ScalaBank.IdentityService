package io.scalaway.identity.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class AccountOutput {
    private String firstName;
    private String lastName;
    private String email;
}
