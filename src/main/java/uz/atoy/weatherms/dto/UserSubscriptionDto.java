package uz.atoy.weatherms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link uz.atoy.weatherms.entity.UserSubscription} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSubscriptionDto implements Serializable {

    private Integer id;

    @NotNull
    private UserInfoDto user;

    @NotNull
    private CityInfoDto city;

}