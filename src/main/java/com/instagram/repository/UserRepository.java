package com.instagram.repository;

import com.instagram.security.model.UserSecurity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserSecurity, String> {

    @Cacheable
    Optional<UserSecurity> findByUsername(String username);

}
