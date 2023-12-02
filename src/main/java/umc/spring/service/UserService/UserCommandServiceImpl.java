package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.apiPayload.code.status.ErrorStatus;
import umc.spring.base.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserPreferFoodCategory;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.UserRequestDTO;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public User joinUser(UserRequestDTO.@Valid JoinDto request) {
        User newUser = userConverter.toUser(request);

        List<FoodCategory> foodCategoryList = request.getPreferCaetgory().stream()
                .map(category -> foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))).collect(Collectors.toList());

        List<UserPreferFoodCategory> userPreferFoodCategoryList = UserPreferConverter.toUserPreferList(foodCategoryList);

        userPreferFoodCategoryList.forEach(userPreferFoodCategory -> {userPreferFoodCategory.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
