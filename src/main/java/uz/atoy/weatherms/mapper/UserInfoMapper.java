package uz.atoy.weatherms.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Service;
import uz.atoy.weatherms.dto.UserInfoDto;
import uz.atoy.weatherms.entity.UserInfo;

@Service
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserInfoMapper {
    UserInfo toEntity(UserInfoDto userInfoDto);

    UserInfoDto toDto(UserInfo userInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserInfo partialUpdate(UserInfoDto userInfoDto, @MappingTarget UserInfo userInfo);
}