package umc.spring.base.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ReasonDTO {
    private String message;
    private String code;
    private Boolean isSuccess;
    private HttpStatus httpStatus;
}