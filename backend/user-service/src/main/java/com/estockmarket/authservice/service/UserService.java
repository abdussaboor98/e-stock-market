package com.estockmarket.authservice.service;

import java.util.List;

import com.estockmarket.authservice.dto.PasswordChangeRequestDTO;
import com.estockmarket.authservice.dto.RegisterUserDTO;
import com.estockmarket.authservice.dto.UserDTO;
import com.estockmarket.authservice.exception.NotFoundException;
import com.estockmarket.authservice.exception.ValueAlreadyInUseException;

public interface UserService {

    public UserDTO registerUser(RegisterUserDTO newUserDTO) throws ValueAlreadyInUseException;

    public UserDTO getUserByUsername(String username) throws NotFoundException;

    public List<UserDTO> getAllUsers();

    public boolean changePassword(PasswordChangeRequestDTO request) throws NotFoundException;
}
