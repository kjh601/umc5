package umc.spring.web.dto;

import lombok.Getter;
import org.locationtech.jts.geom.Point;

public class StoreRequestDTO {

    @Getter
    public static class JoinDTO {
        private String name;
        private String longitude;
        private String latitude;
        private String detailAddress;
        private String imgUrl;
        private Long foodCategoryId;
        private Long zipCodeId;
    }

    @Getter
    public static class ReviewDTO {
        private String contents;
        private Double rating;
        private Long userId;
    }
}
