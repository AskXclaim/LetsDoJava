package org.contactcentre.application.mapper;

import org.contactcentre.domain.model.Child;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.presentation.api.dto.ChildDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChildMapper {
    Child toEntity(ChildDto child) throws DateOfBirthException;
}
