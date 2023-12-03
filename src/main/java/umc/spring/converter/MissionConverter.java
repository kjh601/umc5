package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class MissionConverter {

    public static MissionResponseDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<Mission> missionPage){
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionPage.stream()
                .map(MissionConverter::toMissionPreviewDTO)
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .listSize(missionPage.getSize())
                .missionList(missionPreviewDTOList)
                .totalElements(missionPage.getTotalElements())
                .build();
    }

    private static MissionResponseDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {

        Integer remainDay = (int) DAYS.between(LocalDate.now(), mission.getDeadline());

        return MissionResponseDTO.MissionPreviewDTO.builder()
                .storeName(mission.getStore().getName())
                .foodCategoryName(mission.getStore().getFoodCategory().getName())
                .remainDay(remainDay)
                .contents(mission.getContents())
                .score(mission.getScore())
                .build();
    }
}
