package umc.spring.service.UserService;

import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;

import javax.validation.Valid;

public interface UserCommandService {
    public User joinUser(UserRequestDTO.@Valid JoinDto request);
}
