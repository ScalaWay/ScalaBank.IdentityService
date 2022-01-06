package io.scalaway.identityservice.application.port.api;

import io.scalaway.identityservice.application.usecase.authentication.*;

public interface AuthenticationEndpoint
        extends RegisterUseCase, LoginUseCase, LogoutUseCase, ForgotPasswordUseCase, ResetPasswordUseCase {
}
