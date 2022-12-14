package uz.atoy.weatherms.controller;

import org.springframework.web.bind.annotation.*;
import uz.atoy.weatherms.dto.CityInfoDto;
import uz.atoy.weatherms.dto.UserInfoDto;
import uz.atoy.weatherms.dto.UserSubscriptionDto;
import uz.atoy.weatherms.dto.WeatherInfoDto;
import uz.atoy.weatherms.dto.request.SubscriptionDto;
import uz.atoy.weatherms.dto.response.ResponseEntity;
import uz.atoy.weatherms.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register") // worked
    public ResponseEntity<UserInfoDto> createTokenForNewUser(@RequestBody @NotNull @Valid UserInfoDto userInfoDto) {
        return userService.createTokenForNewUser(userInfoDto);
    }

    @GetMapping("/cities-list")
    public ResponseEntity<List<CityInfoDto>> getAllCities() {
        return userService.getAllCities();
    }

    @PostMapping("/subscribe-to-city")
    public ResponseEntity<List<UserSubscriptionDto>> addCityToSubscription(@RequestBody @NotNull @Valid SubscriptionDto subscriptionDto) {
        return userService.addCityToSubscription(subscriptionDto);
    }

    @GetMapping("/get-subscriptions/{userId}")
    public ResponseEntity<List<WeatherInfoDto>> getWeatherInfoForSubscribedCities(@PathVariable Integer userId) {
        return userService.getWeatherInfoForSubscribedCities(userId);
    }

}
