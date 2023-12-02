package umc.spring.web.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto {
        LocalDate birth;
        String email;
        String phonenumber;
        String userName;
        String nickname;
        String zipCodeContent;
        String detailAddress;
        List<Long> preferCaetgory;
    }
}
