package umc.spring.service.UserMemberService;

import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UserMissionRequestDTO;
public interface UserMissionCommandService {

    public UserMission startMission(UserMissionRequestDTO.StartDTO request, Long missionId);
}
