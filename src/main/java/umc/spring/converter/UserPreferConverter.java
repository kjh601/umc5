package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.mapping.UserPreferFoodCategory;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<UserPreferFoodCategory> toUserPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserPreferFoodCategory.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
