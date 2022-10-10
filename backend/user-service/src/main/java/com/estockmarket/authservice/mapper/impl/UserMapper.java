package com.estockmarket.authservice.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estockmarket.authservice.dto.UserDTO;
import com.estockmarket.authservice.entity.User;
import com.estockmarket.authservice.mapper.EntityDTOMapper;

@Component
public class UserMapper implements EntityDTOMapper<User, UserDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO convertToDTO(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public User converToEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public List<UserDTO> convertToDTOList(List<User> entityList) {
        return entityList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
}
