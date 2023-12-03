package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.base.apiPayload.ApiResponse;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.UserMemberService.UserMissionCommandService;
import umc.spring.web.dto.UserMissionRequestDTO;
import umc.spring.web.dto.UserMissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final UserMissionCommandService userMissionCommandService;

    @PostMapping("/{missionId}")
    public ApiResponse<UserMissionResponseDTO.StartResultDTO>  start(@PathVariable("missionId") Long missionId, @RequestBody @Valid UserMissionRequestDTO.StartDTO request) {
        UserMission userMission = userMissionCommandService.startMission(request, missionId);
        return ApiResponse.onSuccess(UserMissionConverter.toUserMissionResultDTO(userMission));
    }
}
