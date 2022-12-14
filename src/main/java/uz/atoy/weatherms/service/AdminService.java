package uz.atoy.weatherms.service;

import uz.atoy.weatherms.dto.CityInfoDto;
import uz.atoy.weatherms.dto.UserInfoDto;
import uz.atoy.weatherms.dto.UserSubscriptionDto;
import uz.atoy.weatherms.dto.WeatherInfoDto;
import uz.atoy.weatherms.dto.response.ResponseEntity;

import java.util.List;

public interface AdminService {

    ResponseEntity<List<UserInfoDto>> getAllUsers();

    ResponseEntity<List<UserSubscriptionDto>> getUserSubscriptionsByUserId(Integer userId);

    ResponseEntity<UserInfoDto> updateUser(UserInfoDto userInfoDto);

    ResponseEntity<List<CityInfoDto>> getAllCities();

    ResponseEntity<CityInfoDto> updateCity(CityInfoDto cityInfoDto);

    ResponseEntity<WeatherInfoDto> updateWeatherInfo(WeatherInfoDto weatherInfoDto);

}
