package uz.atoy.weatherms.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Service;
import uz.atoy.weatherms.dto.UserSubscriptionDto;
import uz.atoy.weatherms.entity.UserSubscription;

@Service
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {UserInfoMapper.class, CityInfoMapper.class})
public interface UserSubscriptionMapper {
    UserSubscription toEntity(UserSubscriptionDto userSubscriptionDto);

    UserSubscriptionDto toDto(UserSubscription userSubscription);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserSubscription partialUpdate(UserSubscriptionDto userSubscriptionDto, @MappingTarget UserSubscription userSubscription);
}