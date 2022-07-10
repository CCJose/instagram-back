package com.instagram.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Cacheable
    Optional<User> findByUsername(String username);

}
