package com.webconsole.miniappmanager.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.authorization.client.AuthzClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class AuthzClientConfig {
//    @Bean
//    public AuthzClient authzClient(KeycloakSpringBootProperties properties) {
//        var configuration =
//                new org.keycloak.authorization.client.Configuration(
//                        properties.getAuthServerUrl(),
//                        properties.getRealm(),
//                        properties.getResource(),
//                        properties.getCredentials(),
//                        null);
//        return AuthzClient.create(configuration);
//    }
//}
