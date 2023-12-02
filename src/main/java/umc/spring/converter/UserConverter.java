package umc.spring.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.spring.domain.User;
import umc.spring.domain.ZipCode;
import umc.spring.repository.ZipCodeRepository;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.util.ArrayList;

@Component
public class UserConverter {

    private final ZipCodeRepository zipCodeRepository;

    @Autowired
    public UserConverter(ZipCodeRepository zipCodeRepository) {
        this.zipCodeRepository = zipCodeRepository;
    }

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getUserId())
                .createAt(user.getCreateAt())
                .build();
    }

    public User toUser(UserRequestDTO.JoinDto request) {

        ZipCode zipCode = zipCodeRepository.findByContent(request.getZipCodeContent());

        return User.builder()
                .birth(request.getBirth())
                .email(request.getEmail())
                .phonenumber(request.getPhonenumber())
                .userName(request.getUserName())
                .nickname(request.getNickname())
                .zipCode(zipCode)
                .detailAddress(request.getDetailAddress())
                .userPreferFoodCategoryList(new ArrayList<>())
                .build();
    }
}
