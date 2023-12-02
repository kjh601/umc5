package umc.spring.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'closed'")
    private StoreStatus status;

    @Builder.Default
    @ColumnDefault("0.0")
    private Double rating = 0.0;

    @Builder.Default
    @ColumnDefault("0")
    private Integer rateCount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory foodCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zip_code_id")
    private ZipCode zipCode;
}
