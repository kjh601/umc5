package umc.spring.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.locationtech.jts.geom.Point;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.UserStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mapping.UserPreferFoodCategory;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birth;

    @Column(length = 320)
    private String email;

    @Column(length = 15)
    private String phonenumber;

    @Column(length = 20)
    private String userName;

    private String password;

    @Column(length = 20)
    private String nickname;

    private Boolean locationPermission;

    private Boolean marketingPermission;

    private String detailAddress;

    private Point coordinate;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private LocalDate inactiveDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zip_code_id")
    private ZipCode zipCode;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPreferFoodCategory> userPreferFoodCategoryList = new ArrayList<>();
}