package umc.spring.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.locationtech.jts.geom.Point;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.StoreStatus;

import javax.persistence.*;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "POINT")
    private Point coordinate;

    private String detailAddress;

    @Column(columnDefinition = "TEXT")
    private String imgUrl;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private StoreStatus status = StoreStatus.CLOSED;

    @Builder.Default
    private Double rating = 0.0;

    @Builder.Default
    private Integer rateCount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zip_code_id")
    private ZipCode zipCode;

    public void updateStoreRate(Double newReviewRating){
        Integer newStoreRateCount = this.getRateCount()+1;
        Double newStoreRating = (this.getRating()*this.getRateCount()+newReviewRating)/newStoreRateCount;

        this.rateCount = newStoreRateCount;
        this.rating = newStoreRating;
    }
}
