package uz.atoy.weatherms.controller;

import org.springframework.web.bind.annotation.*;
import uz.atoy.weatherms.dto.CityInfoDto;
import uz.atoy.weatherms.dto.UserInfoDto;
import uz.atoy.weatherms.dto.UserSubscriptionDto;
import uz.atoy.weatherms.dto.WeatherInfoDto;
import uz.atoy.weatherms.dto.response.ResponseEntity;
import uz.atoy.weatherms.service.AdminService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/user-list")
    public ResponseEntity<List<UserInfoDto>> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/user-details/{userId}")
    public ResponseEntity<List<UserSubscriptionDto>> getUserSubscriptionsByUserId(@PathVariable Integer userId) {
        return adminService.getUserSubscriptionsByUserId(userId);
    }

    @PutMapping("/edit-user")
    public ResponseEntity<UserInfoDto> updateUser(@RequestBody @NotNull @Valid UserInfoDto userInfoDto) {
        return adminService.updateUser(userInfoDto);
    }

    @GetMapping("/cities-list")
    public ResponseEntity<List<CityInfoDto>> getAllCities() {
        return adminService.getAllCities();
    }

    @PutMapping("/edit-city")
    public ResponseEntity<CityInfoDto> updateCity(@RequestBody @NotNull @Valid CityInfoDto cityInfoDto) {
        return adminService.updateCity(cityInfoDto);
    }

    @PostMapping("/update-city-weather")
    public ResponseEntity<WeatherInfoDto> updateWeatherInfo(@RequestBody @NotNull @Valid WeatherInfoDto weatherInfoDto) {
        return adminService.updateWeatherInfo(weatherInfoDto);
    }

}
