package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import umc.spring.base.apiPayload.code.status.ErrorStatus;
import umc.spring.base.apiPayload.exception.GeneralException;
import umc.spring.base.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.base.apiPayload.exception.handler.ZipCodeHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.*;
import umc.spring.repository.*;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final ZipCodeRepository zipCodeRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Store joinStore(StoreRequestDTO.JoinDTO request) {
        FoodCategory foodCategory = foodCategoryRepository.findById(request.getFoodCategoryId()).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
        ZipCode zipCode = zipCodeRepository.findById(request.getZipCodeId()).orElseThrow(() -> new ZipCodeHandler(ErrorStatus.ZIP_CODE_NOT_FOUND));

        Coordinate coord = new Coordinate(Double.parseDouble(request.getLongitude()), Double.parseDouble(request.getLatitude()));
        GeometryFactory factory = new GeometryFactory();
        Point point = factory.createPoint(coord);

        Store newStore = StoreConverter.toStore(request, point, foodCategory, zipCode);

        return storeRepository.save(newStore);
    }

    @Override
    public Review reviewStore(StoreRequestDTO.ReviewDTO request, Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(()->new GeneralException(ErrorStatus.STORE_NOT_FOUND));
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new GeneralException(ErrorStatus.USER_NOT_FOUND));

        store.updateStoreRate(request.getRating());

        Review newReview = StoreConverter.toReview(request, store, user);
        return reviewRepository.save(newReview);
    }
}
