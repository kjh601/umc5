package umc.spring.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StoreStatus {
    OPEN("open"), CLOSED("closed"), SHUTDOWN("shutdown");

    private final String storeStatus;
}
