package uz.atoy.weatherms.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@NoArgsConstructor
@Data
public class ResponseEntity<T> {

    private T responseBody;

    private Integer statusCode;

    private String errorMessage = "";

    private LocalDateTime dateTime;

    public ResponseEntity(T responseBody) {
        this.responseBody = responseBody;
        this.statusCode = 200;
        this.dateTime = ZonedDateTime.now(ZoneId.of("Asia/Tashkent")).toLocalDateTime();
    }

    public ResponseEntity(String errorMessage, Integer statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.dateTime = ZonedDateTime.now(ZoneId.of("Asia/Tashkent")).toLocalDateTime();
    }

}
