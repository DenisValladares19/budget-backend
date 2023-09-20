package com.budget.controller;

import com.budget.dto.LoginDTO;
import com.budget.dto.ResponseDTO;
import com.budget.dto.UserDTO;
import com.budget.dto.UserDTOWithToken;
import com.budget.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody UserDTO dto) {
        ResponseDTO<UserDTO> response = new ResponseDTO();
        UserDTO userDTO = userService.create(dto);

        response.setCode(ResponseDTO.CODE_SUCCESS);
        response.setMessage(ResponseDTO.MESSAGE_SUCCESS);
        response.setContent(userDTO);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO dto) {
        ResponseDTO<UserDTOWithToken> responseDTO = new ResponseDTO();
        UserDTOWithToken userDTOWithToken = userService.login(dto);

        responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
        responseDTO.setMessage(ResponseDTO.MESSAGE_SUCCESS);
        responseDTO.setContent(userDTOWithToken);

        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseDTO> info(HttpServletRequest request) {
        ResponseDTO<UserDTO> responseDTO = new ResponseDTO();

        responseDTO.setCode(ResponseDTO.CODE_SUCCESS);
        responseDTO.setMessage(ResponseDTO.MESSAGE_SUCCESS);
        responseDTO.setContent(userService.info(request));

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
