package loginJWTReact.persistance.repository;

import loginJWTReact.persistance.entity.ERole;
import loginJWTReact.persistance.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}