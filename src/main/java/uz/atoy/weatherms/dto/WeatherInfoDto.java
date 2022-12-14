package uz.atoy.weatherms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link uz.atoy.weatherms.entity.WeatherInfo} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherInfoDto implements Serializable {
    @NotNull
    private LocalDate date;
    @NotNull
    private Short morning;
    @NotNull
    private Short daytime;
    @NotNull
    private Short evening;
    @NotNull
    private Short humidity;
    @NotNull
    private Short wind;
    @NotNull
    private Short pressure;
    @Size(max = 50)
    @NotNull
    private String moon;
    @Size(max = 5)
    @NotNull
    private String sunrise;
    @Size(max = 5)
    @NotNull
    private String sunset;
    @NotNull
    private CityInfoDto city;
}