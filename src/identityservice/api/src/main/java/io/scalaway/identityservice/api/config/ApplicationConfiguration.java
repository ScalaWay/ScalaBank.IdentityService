package io.scalaway.identityservice.api.config;

import io.scalaway.identityservice.application.port.api.AccountEndpoint;
import io.scalaway.identityservice.application.port.api.AuthenticationEndpoint;
import io.scalaway.identityservice.application.service.AccountEndpointService;
import io.scalaway.identityservice.application.service.AuthenticationEndpointService;
import io.scalaway.identityservice.data.inmemory.repository.InMemoryAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
