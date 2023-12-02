package umc.spring.service.FoodCategoryService;

import java.util.List;

public interface FoodCategoryQueryService {
    boolean existsById(List<Long> values);
}
