package org.contactcentre.presentation.mapper;

import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.model.client.Child;
import org.contactcentre.presentation.dto.ChildDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ChildMapper {
    Child toEntity(ChildDto childDto) throws PersonalDetailException, DateOfBirthException, AddressException;
}
