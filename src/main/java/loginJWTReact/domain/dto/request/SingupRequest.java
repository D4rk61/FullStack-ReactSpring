package loginJWTReact.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link loginJWTReact.persistance.entity.UserEntity}
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SingupRequest implements Serializable {
    @Size(max = 20)
    @NotBlank
    String username;
    @Size(max = 50)
    @Email
    @NotBlank
    String email;
    @Size(max = 120)
    @NotBlank
    String password;

    private Set<String> role;

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}