package uz.atoy.weatherms.service;

import uz.atoy.weatherms.dto.CityInfoDto;
import uz.atoy.weatherms.dto.UserInfoDto;
import uz.atoy.weatherms.dto.UserSubscriptionDto;
import uz.atoy.weatherms.dto.WeatherInfoDto;
import uz.atoy.weatherms.dto.request.SubscriptionDto;
import uz.atoy.weatherms.dto.response.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<UserInfoDto> createTokenForNewUser(UserInfoDto userInfoDto);

    ResponseEntity<List<CityInfoDto>> getAllCities();

    ResponseEntity<List<UserSubscriptionDto>> addCityToSubscription(SubscriptionDto subscriptionDto);

    ResponseEntity<List<WeatherInfoDto>> getWeatherInfoForSubscribedCities(Integer userId);

}
