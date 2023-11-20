package umc.spring.domain;

import lombok.*;
import org.locationtech.jts.geom.Point;
import umc.spring.domain.enums.StoreStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(length = 50)
    private String name;

    private Point coordinate;

    private String detailAddress;

    @Column(columnDefinition = "TEXT")
    private String imgUrl;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StoreStatus status;

    private Double rating;

    private Integer rateCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zip_code_id")
    private ZipCode zipCode;
}
