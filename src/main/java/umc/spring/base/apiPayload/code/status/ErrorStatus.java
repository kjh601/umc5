package umc.spring.base.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.base.apiPayload.code.BaseErrorCode;
import umc.spring.base.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 유저 관련 응답
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    //예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    //For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이것은 테스트"),

    // 음식 카테고리 관련 응답
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD_CATEGORY4011", "음식 카테고리가 없습니다."),

    // ZipCode 관련 응답
    ZIP_CODE_NOT_FOUND(HttpStatus.NOT_FOUND, "ZIP_CODE4021","zip code가 없습니다."),

    // 매장 관련 응답
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE_CODE4031", "매장이 없습니다."),

    // 미션 관련 응답
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION_CODE4041", "미션이 없습니다."),

    // 페이지 관련 응답
    INVALID_PAGE_NUMBER(HttpStatus.BAD_REQUEST, "PAGE_4051", "페이지 번호가 유효하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
