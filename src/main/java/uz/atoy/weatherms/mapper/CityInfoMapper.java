package uz.atoy.weatherms.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Service;
import uz.atoy.weatherms.dto.CityInfoDto;
import uz.atoy.weatherms.entity.CityInfo;

@Service
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityInfoMapper {
    CityInfo toEntity(CityInfoDto cityInfoDto);

    CityInfoDto toDto(CityInfo cityInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CityInfo partialUpdate(CityInfoDto cityInfoDto, @MappingTarget CityInfo cityInfo);
}