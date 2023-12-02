package umc.spring.base.apiPayload.exception.handler;

import umc.spring.base.apiPayload.code.BaseErrorCode;
import umc.spring.base.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
