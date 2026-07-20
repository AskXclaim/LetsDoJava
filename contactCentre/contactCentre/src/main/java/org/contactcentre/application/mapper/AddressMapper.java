package org.contactcentre.application.mapper;

import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.model.Address;
import org.contactcentre.presentation.dto.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toAdress(AddressDto addressDto) throws AddressException;
}
