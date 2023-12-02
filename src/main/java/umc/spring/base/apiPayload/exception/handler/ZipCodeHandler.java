package umc.spring.base.apiPayload.exception.handler;

import umc.spring.base.apiPayload.code.BaseErrorCode;
import umc.spring.base.apiPayload.exception.GeneralException;

public class ZipCodeHandler extends GeneralException {
    public ZipCodeHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
