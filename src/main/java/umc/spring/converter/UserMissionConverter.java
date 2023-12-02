package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UserMissionResponseDTO;

public class UserMissionConverter {

    public static UserMission toUserMission(MissionStatus status, User user, Mission mission) {
        return UserMission.builder()
                .status(status)
                .user(user)
                .mission(mission)
                .build();
    }

    public static UserMissionResponseDTO.StartResultDTO toUserMissionResultDTO(UserMission userMission) {
        return UserMissionResponseDTO.StartResultDTO.builder()
                .userMissionId(userMission.getUserMissionId())
                .createAt(userMission.getCreateAt())
                .build();
    }
}
