package umc.spring.service.UserService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

public interface UserQueryService {
    Page<Review> getReviewList(Long userId, Integer page);

    Page<Mission> getMissionList(Long userId, Integer page);
}
