package com.csit314.bananacat.bananacatbackend;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserProfileRepositoryInjector {
    public static UserProfileRepository repo;

    @Autowired
    public UserProfileRepositoryInjector(UserProfileRepository injectrepo) {
        UserProfileRepositoryInjector.repo = injectrepo;
    }

}
