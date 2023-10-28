package loginJWTReact.persistance.repository;

import loginJWTReact.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByUsername(String username);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}