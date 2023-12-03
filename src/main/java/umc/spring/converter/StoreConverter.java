package umc.spring.converter;

import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.Page;
import umc.spring.domain.*;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO.JoinDTO request, Point point, FoodCategory foodCategory, ZipCode zipCode){

        return Store.builder()
                .name(request.getName())
                .coordinate(point)
                .detailAddress(request.getDetailAddress())
                .imgUrl(request.getImgUrl())
                .foodCategory(foodCategory)
                .zipCode(zipCode)
                .build();

    }

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getStoreId())
                .createAt(store.getCreateAt())
                .build();
    }
}
