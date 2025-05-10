package com.csit314.bananacat.bananacatbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAccountRepositoryInjector {
    // This class is used to inject the repositories into the services
    // This is a workaround for the circular dependency issue in Spring Boot
    public static UserAccountRepository repo;

    @Autowired
    public UserAccountRepositoryInjector(UserAccountRepository injectrepo) {
        UserAccountRepositoryInjector.repo = injectrepo;
    } 
}
