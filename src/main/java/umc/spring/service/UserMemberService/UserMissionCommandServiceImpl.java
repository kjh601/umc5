package umc.spring.service.UserMemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import umc.spring.base.apiPayload.code.status.ErrorStatus;
import umc.spring.base.apiPayload.exception.GeneralException;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.UserMissionRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.UserMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService{
    private final UserMissionRepository userMissionRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;

    @Override
    public UserMission startMission(UserMissionRequestDTO.StartDTO request, Long missionId) {

        Mission mission = missionRepository.findById(missionId).orElseThrow(()-> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));
        User user = userRepository.findById(request.getUserId()).orElseThrow(()->new GeneralException(ErrorStatus.USER_NOT_FOUND));

        UserMission userMission = UserMissionConverter.toUserMission(MissionStatus.STARTED  ,user, mission);
        return userMissionRepository.save(userMission);
    }
}
