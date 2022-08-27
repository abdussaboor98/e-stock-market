package com.estockmarket.companyservice.mapper;

public interface EntityDTOMapper<E, D> {

    /**
     * Converts Entity to DTO
     * @param entity
     * @return dto
     */
    D convertToDTO(E entity);

    /**
     * Converts DTO to Entity
     * @param dto
     * @return entity
     */
    E converToEntity(D dto);
}
