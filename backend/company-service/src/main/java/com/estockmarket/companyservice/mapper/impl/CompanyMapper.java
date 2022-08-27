package com.estockmarket.companyservice.mapper.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.estockmarket.companyservice.dto.CompanyDTO;
import com.estockmarket.companyservice.entity.Company;
import com.estockmarket.companyservice.mapper.IEntityDTOMapper;

public class CompanyMapper implements IEntityDTOMapper<Company, CompanyDTO> {

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
    
}
