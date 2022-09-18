package com.estockmarket.stockservice.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estockmarket.stockservice.dto.StockBaseDTO;
import com.estockmarket.stockservice.dto.StockDTO;
import com.estockmarket.stockservice.entity.Stock;
import com.estockmarket.stockservice.mapper.EntityDTOMapper;

@Component
public class StockMapper implements EntityDTOMapper<Stock, StockBaseDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StockDTO convertToDTO(Stock entity) {
        return modelMapper.map(entity, StockDTO.class);
    }

    @Override
    public Stock converToEntity(StockBaseDTO dto) {
        return modelMapper.map(dto, Stock.class);
    }

    public List<StockBaseDTO> convertToBaseDTOList(List<Stock> entityList) {
        return entityList.parallelStream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<StockDTO> convertToDTOList(List<Stock> entityList) {
        return entityList.parallelStream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
}
