package umc.spring.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.apiPayload.code.status.ErrorStatus;
import umc.spring.base.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TempQueryServiceImpl implements TempQueryService{
    // GET 요청에 대한 비즈니스 로직을 처리하는 클래스

    @Override
    public void CheckFlag(Integer flag) {
        if(flag==1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
