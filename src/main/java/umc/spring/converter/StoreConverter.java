package umc.spring.converter;

import org.locationtech.jts.geom.Point;
import umc.spring.domain.*;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

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

    public static Review toReview(StoreRequestDTO.ReviewDTO request, Store store, User user) {
        return Review.builder()
                .contents(request.getContents())
                .rating(request.getRating())
                .store(store)
                .user(user)
                .build();
    }

    public static StoreResponseDTO.ReviewResultDTO toReviewResultDTO(Review review) {
        return StoreResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .createAt(review.getCreateAt())
                .build();
    }
}
