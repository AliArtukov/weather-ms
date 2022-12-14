package uz.atoy.weatherms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.atoy.weatherms.dto.CityInfoDto;
import uz.atoy.weatherms.dto.UserInfoDto;
import uz.atoy.weatherms.dto.UserSubscriptionDto;
import uz.atoy.weatherms.dto.WeatherInfoDto;
import uz.atoy.weatherms.dto.request.SubscriptionDto;
import uz.atoy.weatherms.dto.response.ResponseEntity;
import uz.atoy.weatherms.entity.CityInfo;
import uz.atoy.weatherms.entity.UserInfo;
import uz.atoy.weatherms.entity.UserSubscription;
import uz.atoy.weatherms.mapper.CityInfoMapper;
import uz.atoy.weatherms.mapper.UserInfoMapper;
import uz.atoy.weatherms.mapper.UserSubscriptionMapper;
import uz.atoy.weatherms.mapper.WeatherInfoMapper;
import uz.atoy.weatherms.repository.CityInfoRepository;
import uz.atoy.weatherms.repository.UserInfoRepository;
import uz.atoy.weatherms.repository.UserSubscriptionRepository;
import uz.atoy.weatherms.repository.WeatherInfoRepository;
import uz.atoy.weatherms.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final WeatherInfoMapper weatherInfoMapper;
    private final UserSubscriptionMapper userSubscriptionMapper;
    private final CityInfoMapper cityInfoMapper;
    private final UserInfoMapper userInfoMapper;

    private final UserInfoRepository userInfoRepository;
    private final WeatherInfoRepository weatherInfoRepository;
    private final CityInfoRepository cityInfoRepository;
    private final UserSubscriptionRepository userSubscriptionRepository;

    public UserServiceImpl(WeatherInfoMapper weatherInfoMapper, UserSubscriptionMapper userSubscriptionMapper, CityInfoMapper cityInfoMapper, UserInfoMapper userInfoMapper, UserInfoRepository userInfoRepository, WeatherInfoRepository weatherInfoRepository, CityInfoRepository cityInfoRepository, UserSubscriptionRepository userSubscriptionRepository) {
        this.weatherInfoMapper = weatherInfoMapper;
        this.userSubscriptionMapper = userSubscriptionMapper;
        this.cityInfoMapper = cityInfoMapper;
        this.userInfoMapper = userInfoMapper;
        this.userInfoRepository = userInfoRepository;
        this.weatherInfoRepository = weatherInfoRepository;
        this.cityInfoRepository = cityInfoRepository;
        this.userSubscriptionRepository = userSubscriptionRepository;
    }

    @Override
    public ResponseEntity<UserInfoDto> createTokenForNewUser(@RequestBody @NotNull @Valid UserInfoDto userInfoDto) {
        if (Objects.isNull(userInfoDto.getLogin()) || Objects.isNull(userInfoDto.getPassword()))
            return new ResponseEntity<>("Login or password not found!", 406);

        String decodedString = userInfoDto.getLogin() + ":" + userInfoDto.getPassword();
        String encodedString = Base64.getEncoder().encodeToString(decodedString.getBytes());
        UserInfo userInfo = userInfoMapper.toEntity(userInfoDto);
        userInfo.setBaseToken(encodedString);
        userInfo = userInfoRepository.save(userInfo);
        return new ResponseEntity<>(userInfoMapper.toDto(userInfo));
    }

    @Override
    public ResponseEntity<List<CityInfoDto>> getAllCities() {
        return new ResponseEntity<>(
                cityInfoRepository.findAllByEnabled(true).stream()
                        .map(cityInfoMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<List<UserSubscriptionDto>> addCityToSubscription(@RequestBody @NotNull @Valid SubscriptionDto subscriptionDto) {
        if (Objects.isNull(subscriptionDto.getUserId()))
            return new ResponseEntity<>("User id not found!", 406);

        if (Objects.isNull(subscriptionDto.getCityId()))
            return new ResponseEntity<>("City id not found!", 406);

        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(subscriptionDto.getUserId());
        if (userInfoOptional.isEmpty())
            return new ResponseEntity<>("User not found!", 204);

        Optional<CityInfo> cityInfoOptional = cityInfoRepository.findByIdAndEnabled(subscriptionDto.getCityId(), true);
        if (cityInfoOptional.isEmpty())
            return new ResponseEntity<>("City not found!", 204);

        UserSubscription userSubscription = new UserSubscription();
        userSubscription.setUser(userInfoOptional.get());
        userSubscription.setCity(cityInfoOptional.get());
        userSubscriptionRepository.save(userSubscription);

        List<UserSubscription> userSubscriptionList = userSubscriptionRepository.findAllByUser_Id(subscriptionDto.getUserId());
        return new ResponseEntity<>(
                userSubscriptionList.stream()
                        .map(userSubscriptionMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<List<WeatherInfoDto>> getWeatherInfoForSubscribedCities(@PathVariable Integer userId) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(userId);
        if (userInfoOptional.isEmpty())
            return new ResponseEntity<>("User not found!", 204);

        return new ResponseEntity<>(
                weatherInfoRepository.findWeatherInfosByUserId(userId).stream()
                        .map(weatherInfoMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

}
