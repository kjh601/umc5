package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static Review toReview(StoreRequestDTO.ReviewDTO request, Store store, User user) {
        return Review.builder()
                .contents(request.getContents())
                .rating(request.getRating())
                .store(store)
                .user(user)
                .build();
    }

    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review) {
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getReviewId())
                .createAt(review.getCreateAt())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review){
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .nickname(review.getUser().getNickname())
                .rating(review.getRating())
                .createAt(review.getCreateAt())
                .contents(review.getContents())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewList) {

        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewListDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewPreviewDTO)
                .collect(Collectors.toList());
        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .listSize(reviewList.getSize())
                .reviewList(reviewPreviewListDTOList)
                .totalElements(reviewList.getTotalElements())
                .build();
    }
}
