package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.base.apiPayload.code.status.ErrorStatus;
import umc.spring.base.apiPayload.exception.GeneralException;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService{
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Page<Review> getReviewList(Long userId, Integer page) {
        User user = userRepository.findById(userId).orElseThrow(()->new GeneralException(ErrorStatus.USER_NOT_FOUND));
        Page<Review> reviewPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        return reviewPage;
    }
}
