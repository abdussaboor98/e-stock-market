package com.estockmarket.companyservice.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estockmarket.companyservice.dto.CompanyDTO;
import com.estockmarket.companyservice.entity.Company;
import com.estockmarket.companyservice.mapper.EntityDTOMapper;

@Component
public class CompanyMapper implements EntityDTOMapper<Company, CompanyDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CompanyDTO convertToDTO(Company entity) {
        return modelMapper.map(entity, CompanyDTO.class);
    }

    @Override
    public Company converToEntity(CompanyDTO dto) {
        return modelMapper.map(dto, Company.class);
    }

    public List<CompanyDTO> convertToDTOList(List<Company> entityList) {
        return entityList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
}
