package umc.spring.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Point;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mapping.UserPreferFoodCategory;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

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
    private MemberStatus status;

    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPreferFoodCategory> userPreferFoodCategoryList = new ArrayList<>();
}
