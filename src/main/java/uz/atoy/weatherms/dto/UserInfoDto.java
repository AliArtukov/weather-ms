package uz.atoy.weatherms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link uz.atoy.weatherms.entity.UserInfo} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoDto implements Serializable {

    private Integer id;

    private String login;

    private String password;

    @Size(max = 50)
    private String firstname;

    @Size(max = 50)
    private String lastname;

    private String baseToken;

}