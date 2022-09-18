package com.estockmarket.stockservice.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estockmarket.stockservice.dto.StockDTO;
import com.estockmarket.stockservice.entity.Stock;
import com.estockmarket.stockservice.mapper.EntityDTOMapper;

@Component
public class StockMapper implements EntityDTOMapper<Stock, StockDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StockDTO convertToDTO(Stock entity) {
        return modelMapper.map(entity, StockDTO.class);
    }

    @Override
    public Stock converToEntity(StockDTO dto) {
        return modelMapper.map(dto, Stock.class);
    }

    public List<StockDTO> convertToDTOList(List<Stock> entityList) {
        return entityList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
}
