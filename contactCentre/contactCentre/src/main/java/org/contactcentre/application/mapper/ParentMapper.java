package org.contactcentre.application.mapper;

import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.domain.model.client.Parent;
import org.contactcentre.presentation.api.dto.ParentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParentMapper {
    Parent toEntity(ParentDto parentDto) throws TitleException;
}
