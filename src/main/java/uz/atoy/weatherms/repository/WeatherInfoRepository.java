package uz.atoy.weatherms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.atoy.weatherms.entity.WeatherInfo;

import java.util.List;

//@Repository
public interface WeatherInfoRepository extends JpaRepository<WeatherInfo, Integer> {

    @Query(
            value = "select wi.id, wi.date, wi.morning, wi.daytime, wi.evening, wi.humidity, wi.wind, wi.pressure, wi.moon, wi.sunrise, wi.sunset, wi.city_id \n" +
                    "from weather_info wi \n" +
                    "inner join user_subscription us on wi.city_id = us.city_id \n" +
                    "where us.user_id = :userId",
            nativeQuery = true
    )
    List<WeatherInfo> findWeatherInfosByUserId(@Param("userId") Integer userId);

}