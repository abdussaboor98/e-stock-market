package com.estockmarket.authservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estockmarket.authservice.dto.PasswordChangeRequestDTO;
import com.estockmarket.authservice.dto.RegisterUserDTO;
import com.estockmarket.authservice.dto.UserDTO;
import com.estockmarket.authservice.entity.User;
import com.estockmarket.authservice.exception.NotFoundException;
import com.estockmarket.authservice.exception.ValueAlreadyInUseException;
import com.estockmarket.authservice.mapper.impl.UserMapper;
import com.estockmarket.authservice.repo.UserRepo;
import com.estockmarket.authservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(RegisterUserDTO newUserDTO) throws ValueAlreadyInUseException {
        if (userRepo.findByEmail(newUserDTO.getEmail()).isPresent()) {
            throw new ValueAlreadyInUseException(ValueAlreadyInUseException.EMAIL_ALREADY_IN_USE);
        }

        if (userRepo.findByUsername(newUserDTO.getUsername()).isPresent()) {
            throw new ValueAlreadyInUseException(ValueAlreadyInUseException.USERNAME_ALREADY_IN_USE);
        }

        // Set the password with the encoding
        // newUserDTO.setPassword(passwordEncoder.encode(newUserDTO.getPassword()));

        User user = userMapper.converToEntity(newUserDTO);
        return userMapper.convertToDTO(userRepo.save(user));
    }

    @Override
    public UserDTO getUserByUsername(String username) throws NotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isPresent()) {
            return userMapper.convertToDTO(user.get());
        } else {
            throw new NotFoundException(NotFoundException.USER_NOT_FOUND);
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = userMapper.convertToDTOList(userRepo.findAll());
        log.info("Fetched {} users", users.size());
        return users;
    }

    @Override
    public boolean changePassword(PasswordChangeRequestDTO request) throws NotFoundException {


        User user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new NotFoundException(NotFoundException.USER_NOT_FOUND));

        // Encode passwords
        // request.setOldPassword(passwordEncoder.encode(request.getOldPassword()));
        // request.setNewPassword(passwordEncoder.encode(request.getNewPassword()));

		if (user.getPassword().equals(request.getOldPassword())) {
            user.setPassword(request.getNewPassword());
            userRepo.save(user);
            return true;
        } else
            return false;
    }

    // // For spring security
    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     UserEntity userEntity = usersRepo.findByUsername(username)
    //             .orElseThrow(() -> new UsernameNotFoundException("The username '" + username + "' is not found."));
    //     return new org.springframework.security.core.userdetails.User(userEntity.getUsername(),
    //             userEntity.getPassword(), new ArrayList<>());
    // }
}
