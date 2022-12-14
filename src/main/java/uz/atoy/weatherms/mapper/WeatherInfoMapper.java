package uz.atoy.weatherms.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Service;
import uz.atoy.weatherms.dto.WeatherInfoDto;
import uz.atoy.weatherms.entity.WeatherInfo;

@Service
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {CityInfoMapper.class})
public interface WeatherInfoMapper {
    WeatherInfo toEntity(WeatherInfoDto weatherInfoDto);

    WeatherInfoDto toDto(WeatherInfo weatherInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    WeatherInfo partialUpdate(WeatherInfoDto weatherInfoDto, @MappingTarget WeatherInfo weatherInfo);
}