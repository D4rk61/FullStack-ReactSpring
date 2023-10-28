package loginJWTReact.bootstrap;

import loginJWTReact.persistance.entity.ERole;
import loginJWTReact.persistance.entity.Role;
import loginJWTReact.persistance.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Component
public class RoleSeeder implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(RoleSeeder.class);

    @Autowired
    private IRoleRepository roleRepository;


    private void seedRolesTable() {
        ERole[] roleNames = { ERole.ROLE_USER, ERole.ROLE_MODERATOR, ERole.ROLE_ADMIN };

        Map<ERole, String> rolesMap = Map.of(
            ERole.ROLE_USER, "Default role",
            ERole.ROLE_MODERATOR , "Moderator role",
            ERole.ROLE_ADMIN , "Admin role");

        Arrays.stream(roleNames).forEach(roleName -> {
            Optional<Role> optionalRole = roleRepository.findByName(roleName);

            optionalRole.ifPresentOrElse(role -> logger.info(role.toString()), () -> {
                Role roleToCreate = new Role();

                roleToCreate.setName(roleName);
                roleToCreate.setDescription(rolesMap.get(roleName));

                roleRepository.save(roleToCreate);
            });
        });
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.seedRolesTable();
    }
}
