package com.estockmarket.companyservice.mapper;

public interface IEntityDTOMapper<E, D> {

    D convertToDTO(E entity);

    E converToEntity(D dto);
}
