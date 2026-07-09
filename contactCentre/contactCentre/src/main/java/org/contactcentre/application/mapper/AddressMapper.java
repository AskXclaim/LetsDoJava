package org.contactcentre.application.mapper;

import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.model.client.Address;
import org.contactcentre.presentation.api.dto.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity(AddressDto addressDto) throws AddressException;
}
