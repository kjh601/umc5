package umc.spring.service.FoodCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository;

import java.util.List;

@Service
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService {

    private final FoodCategoryRepository foodCategoryRepository;
    @Autowired
    FoodCategoryQueryServiceImpl(FoodCategoryRepository foodCategoryRepository){
        this.foodCategoryRepository = foodCategoryRepository;
    }

    @Override
    public boolean existsById(List<Long> values) {
        return values.stream().allMatch(value -> foodCategoryRepository.existsById(value));
    }
}
