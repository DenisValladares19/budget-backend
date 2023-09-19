package com.budget.service;

import com.budget.dto.LoginDTO;
import com.budget.dto.UserDTO;
import com.budget.dto.UserDTOWithToken;

public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTOWithToken login(LoginDTO dto);
    void logout(UserDTO dto);
    UserDTO update(UserDTO dto);
    void delete(Long userId);
    UserDTO getById(Long userId);
    UserDTO getByEmail(String email);
}
