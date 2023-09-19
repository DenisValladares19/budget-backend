package com.budget.service;

import com.budget.dto.LoginDTO;
import com.budget.dto.UserDTO;

public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTO login(LoginDTO dto);
    void logout(UserDTO dto);
    UserDTO update(UserDTO dto);
    void delete(Long userId);
    UserDTO getById(Long userId);
    UserDTO getByEmail(String email);
}
