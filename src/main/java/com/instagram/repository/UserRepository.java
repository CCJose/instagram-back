package com.instagram.repository;

import com.instagram.security.model.UserSecurity;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserSecurity, String> {

  @Cacheable
  Optional<UserSecurity> findByUsername(String username);
}
