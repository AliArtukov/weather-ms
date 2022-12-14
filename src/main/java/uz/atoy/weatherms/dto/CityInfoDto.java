package uz.atoy.weatherms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link uz.atoy.weatherms.entity.CityInfo} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CityInfoDto implements Serializable {

    private Integer id;

    @Size(max = 50)
    @NotNull
    private String name;

    @Size(max = 50)
    @NotNull
    private String country;

    @NotNull
    private Boolean enabled;

}