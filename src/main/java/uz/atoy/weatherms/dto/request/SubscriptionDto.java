package uz.atoy.weatherms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubscriptionDto {
    @NotNull
    private Integer userId;
    @NotNull
    private Integer cityId;
}
