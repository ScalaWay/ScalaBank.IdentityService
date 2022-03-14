package io.scalaway.identity.application.port.api;

import io.scalaway.identity.application.usecase.authentication.*;

public interface AuthenticationEndpoint
        extends RegisterUseCase, LoginUseCase, LogoutUseCase, ForgotPasswordUseCase, ResetPasswordUseCase {
}
