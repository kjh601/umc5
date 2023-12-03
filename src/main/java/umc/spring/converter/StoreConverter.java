package umc.spring.converter;

import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.Page;
import umc.spring.domain.*;
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

    public static StoreResponseDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review){
        return StoreResponseDTO.ReviewPreviewDTO.builder()
                .nickname(review.getUser().getNickname())
                .rating(review.getRating())
                .createAt(review.getCreateAt())
                .contents(review.getContents())
                .build();
    }

    public static StoreResponseDTO.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewList) {

        List<StoreResponseDTO.ReviewPreviewDTO> reviewPreviewListDTOList = reviewList.stream()
                .map(StoreConverter::toReviewPreviewDTO)
                .collect(Collectors.toList());
        return StoreResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .listSize(reviewList.getSize())
                .reviewList(reviewPreviewListDTOList)
                .totalElements(reviewList.getTotalElements())
                .build();
    }
}
