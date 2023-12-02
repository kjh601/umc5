package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.spring.base.apiPayload.code.status.ErrorStatus;
import umc.spring.base.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.base.apiPayload.exception.handler.ZipCodeHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Store;
import umc.spring.domain.ZipCode;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.repository.ZipCodeRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final ZipCodeRepository zipCodeRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Store joinStore(StoreRequestDTO.JoinDTO request) {
        FoodCategory foodCategory = foodCategoryRepository.findById(request.getFoodCategoryId()).orElseThrow(()->new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
        ZipCode zipCode = zipCodeRepository.findById(request.getZipCodeId()).orElseThrow(() -> new ZipCodeHandler(ErrorStatus.ZIP_CODE_NOT_FOUND));

        Coordinate coord = new Coordinate(Double.parseDouble(request.getLongitude()), Double.parseDouble(request.getLatitude()));
        GeometryFactory factory = new GeometryFactory();
        Point point = factory.createPoint(coord);

        Store newStore = StoreConverter.toStore(request, point, foodCategory, zipCode);

        return storeRepository.save(newStore);
    }
}
