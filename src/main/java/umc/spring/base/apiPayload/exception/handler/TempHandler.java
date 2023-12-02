package umc.spring.base.apiPayload.exception.handler;

import umc.spring.base.apiPayload.code.BaseErrorCode;
import umc.spring.base.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
