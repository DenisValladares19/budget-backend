package com.budget.controller;

import com.budget.dto.ResponseDTO;
import com.budget.dto.UserDTO;
import com.budget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody UserDTO dto) {
        ResponseDTO<UserDTO> response = new ResponseDTO();
        UserDTO userDTO = userService.create(dto);

        response.setCode(ResponseDTO.CODE_SUCCESS);
        response.setMessage(ResponseDTO.MESSAGE_SUCCESS);
        response.setContent(userDTO);

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
