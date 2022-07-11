package tech.anjolaakindipe.springsecuritypractice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tech.anjolaakindipe.springsecuritypractice.domain.Role;

@Repository
public interface RoleRespository extends MongoRepository<Role, String> {
    Optional<Role> findByName(String name);
}
