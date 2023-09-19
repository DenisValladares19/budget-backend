package com.budget.service;

import com.budget.dto.MovementDTO;

import java.util.List;

public interface MovementService {
    List<MovementDTO> getAll(Long userId);
    MovementDTO create(MovementDTO dto);
    MovementDTO getById(Long movementId);
}
