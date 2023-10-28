package loginJWTReact.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link loginJWTReact.persistance.entity.UserEntity}
 */
@Getter @Setter @NoArgsConstructor  @AllArgsConstructor
public class LoginRequest implements Serializable {
    @Size(max = 20)
    @NotBlank
    String username;
    @NotBlank
    private String password;

}