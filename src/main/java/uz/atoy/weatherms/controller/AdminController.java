package uz.atoy.weatherms.controller;

import org.springframework.web.bind.annotation.*;
import uz.atoy.weatherms.dto.CityInfoDto;
import uz.atoy.weatherms.dto.UserInfoDto;
import uz.atoy.weatherms.dto.UserSubscriptionDto;
import uz.atoy.weatherms.dto.WeatherInfoDto;
import uz.atoy.weatherms.dto.response.ResponseEntity;
import uz.atoy.weatherms.entity.CityInfo;
import uz.atoy.weatherms.entity.UserInfo;
import uz.atoy.weatherms.entity.UserSubscription;
import uz.atoy.weatherms.entity.WeatherInfo;
import uz.atoy.weatherms.mapper.CityInfoMapper;
import uz.atoy.weatherms.mapper.UserInfoMapper;
import uz.atoy.weatherms.mapper.UserSubscriptionMapper;
import uz.atoy.weatherms.mapper.WeatherInfoMapper;
import uz.atoy.weatherms.repository.CityInfoRepository;
import uz.atoy.weatherms.repository.UserInfoRepository;
import uz.atoy.weatherms.repository.UserSubscriptionRepository;
import uz.atoy.weatherms.repository.WeatherInfoRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final UserInfoMapper userInfoMapper;
    private final UserSubscriptionMapper userSubscriptionMapper;
    private final CityInfoMapper cityInfoMapper;
    private final WeatherInfoMapper weatherInfoMapper;

    private final UserInfoRepository userInfoRepository;
    private final UserSubscriptionRepository userSubscriptionRepository;
    private final CityInfoRepository cityInfoRepository;
    private final WeatherInfoRepository weatherInfoRepository;

    public AdminController(UserInfoMapper userInfoMapper, UserSubscriptionMapper userSubscriptionMapper, CityInfoMapper cityInfoMapper, WeatherInfoMapper weatherInfoMapper, UserInfoRepository userInfoRepository, UserSubscriptionRepository userSubscriptionRepository, CityInfoRepository cityInfoRepository,
                           WeatherInfoRepository weatherInfoRepository) {
        this.userInfoMapper = userInfoMapper;
        this.userSubscriptionMapper = userSubscriptionMapper;
        this.cityInfoMapper = cityInfoMapper;
        this.weatherInfoMapper = weatherInfoMapper;
        this.userInfoRepository = userInfoRepository;
        this.userSubscriptionRepository = userSubscriptionRepository;
        this.cityInfoRepository = cityInfoRepository;
        this.weatherInfoRepository = weatherInfoRepository;
    }

    @GetMapping("/user-list")
    public ResponseEntity<List<UserInfoDto>> getAllUsers() {
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        return new ResponseEntity<>(
                userInfoList.stream()
                        .map(userInfoMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/user-details/{userId}")
    public ResponseEntity<List<UserSubscriptionDto>> getUserSubscriptionsByUserId(@PathVariable Integer userId) {
        List<UserSubscription> userSubscriptionList = userSubscriptionRepository.findAllByUser_Id(userId);
        return new ResponseEntity<>(
                userSubscriptionList.stream()
                        .map(userSubscriptionMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    @PutMapping("/edit-user")
    public ResponseEntity<UserInfoDto> updateUser(@RequestBody @NotNull @Valid UserInfoDto userInfoDto) {
        if (Objects.isNull(userInfoDto.getId()))
            return new ResponseEntity<>("User id not found!", 406);

        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(userInfoDto.getId());
        if (userInfoOptional.isEmpty())
            return new ResponseEntity<>("User not found!", 204);

        String decodedString = userInfoDto.getLogin() + ":" + userInfoDto.getPassword();
        String encodedString = Base64.getEncoder().encodeToString(decodedString.getBytes());
        UserInfo userInfo = userInfoOptional.get();
        userInfo = userInfoMapper.partialUpdate(userInfoDto, userInfo);
        userInfo.setBaseToken(encodedString);
        userInfo = userInfoRepository.save(userInfo);
        return new ResponseEntity<>(userInfoMapper.toDto(userInfo));
    }

    @GetMapping("/cities-list")
    public ResponseEntity<List<CityInfoDto>> getAllCities() {
        return new ResponseEntity<>(
                cityInfoRepository.findAll().stream()
                        .map(cityInfoMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    @PutMapping("/edit-city")
    public ResponseEntity<CityInfoDto> updateCity(@RequestBody @NotNull @Valid CityInfoDto cityInfoDto) {
        if (Objects.isNull(cityInfoDto.getId()))
            return new ResponseEntity<>("City id not found!", 406);

        Optional<CityInfo> cityInfoOptional = cityInfoRepository.findById(cityInfoDto.getId());
        if (cityInfoOptional.isEmpty())
            return new ResponseEntity<>("City not found!", 204);

        CityInfo cityInfo = cityInfoOptional.get();
        cityInfo = cityInfoMapper.partialUpdate(cityInfoDto, cityInfo);
        cityInfo = cityInfoRepository.save(cityInfo);
        return new ResponseEntity<>(cityInfoMapper.toDto(cityInfo));
    }

    @PostMapping("/update-city-weather")
    public ResponseEntity<WeatherInfoDto> updateWeatherInfo(@RequestBody @NotNull @Valid WeatherInfoDto weatherInfoDto) {
        if (Objects.isNull(weatherInfoDto.getCity()) || Objects.isNull(weatherInfoDto.getCity().getId()))
            return new ResponseEntity<>("City id not found!", 406);

        Optional<CityInfo> cityInfoOptional = cityInfoRepository.findById(weatherInfoDto.getCity().getId());
        if (cityInfoOptional.isEmpty())
            return new ResponseEntity<>("City not found in DB!", 204);

        WeatherInfo weatherInfo = weatherInfoMapper.toEntity(weatherInfoDto);
        weatherInfo.setCity(cityInfoOptional.get());
        weatherInfo = weatherInfoRepository.save(weatherInfo);
        weatherInfoDto = weatherInfoMapper.toDto(weatherInfo);
        return new ResponseEntity<>(weatherInfoDto);
    }

}
