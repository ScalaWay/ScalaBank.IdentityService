package io.scalaway.identity.api.config;

import io.scalaway.identity.application.port.api.AccountEndpoint;
import io.scalaway.identity.application.port.api.AuthenticationEndpoint;
import io.scalaway.identity.application.service.AccountEndpointService;
import io.scalaway.identity.application.service.AuthenticationEndpointService;
import io.scalaway.identity.data.inmemory.repository.InMemoryAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    // Persistence
    @Bean
    public InMemoryAccountRepository inMemoryAccountRepository(){
        return new InMemoryAccountRepository();
    }

    // Application
    @Bean
    public AuthenticationEndpoint authenticationEndpoint(){
        return new AuthenticationEndpointService(this.inMemoryAccountRepository());
    }

    @Bean
    public AccountEndpoint accountEndpoint(){
        return new AccountEndpointService(this.inMemoryAccountRepository());
    }

}
