package uz.atoy.weatherms.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = WeatherInfo.TABLE_NAME)
public class WeatherInfo {
    public static final String TABLE_NAME = "weather_info";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull
    @Column(name = "morning", nullable = false)
    private Short morning;

    @NotNull
    @Column(name = "daytime", nullable = false)
    private Short daytime;

    @NotNull
    @Column(name = "evening", nullable = false)
    private Short evening;

    @NotNull
    @Column(name = "humidity", nullable = false)
    private Short humidity;

    @NotNull
    @Column(name = "wind", nullable = false)
    private Short wind;

    @NotNull
    @Column(name = "pressure", nullable = false)
    private Short pressure;

    @Size(max = 50)
    @NotNull
    @Column(name = "moon", nullable = false, length = 50)
    private String moon;

    @Size(max = 5)
    @NotNull
    @Column(name = "sunrise", nullable = false, length = 5)
    private String sunrise;

    @Size(max = 5)
    @NotNull
    @Column(name = "sunset", nullable = false, length = 5)
    private String sunset;

    @ToString.Exclude
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private CityInfo city;

}