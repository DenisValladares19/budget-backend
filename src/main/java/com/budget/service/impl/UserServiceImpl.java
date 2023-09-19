package com.budget.service.impl;

import com.budget.dto.LoginDTO;
import com.budget.dto.UserDTO;
import com.budget.entity.Budget;
import com.budget.entity.User;
import com.budget.exception.RequestException;
import com.budget.repository.BudgetRepository;
import com.budget.repository.UserRepository;
import com.budget.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public UserDTO create(UserDTO dto) {
        Optional<User> exists = userRepository.findByEmail(dto.getEmail());

        if (!exists.isEmpty()) {
            throw new RequestException("Email is already");
        }

        Budget budget = new Budget();
        User user = modelMapper.map(dto, User.class);
        user = userRepository.save(user);

        budget.setUser(user);
        budget.setAmount(0.00);
        budgetRepository.save(budget);

        user.setBudget(budget);
        userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO login(LoginDTO dto) {
        return null;
    }

    @Override
    public void logout(UserDTO dto) {

    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    public void delete(Long userId) {

    }

    @Override
    public UserDTO getById(Long userId) {
        if (userId == null) {
            throw new RequestException("userId is required");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RequestException("User not found where id = " + userId));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getByEmail(String email) {
        if (email == null) {
            throw new RequestException("email is required");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RequestException("User not found where email = " + email));

        return modelMapper.map(user, UserDTO.class);
    }
}
