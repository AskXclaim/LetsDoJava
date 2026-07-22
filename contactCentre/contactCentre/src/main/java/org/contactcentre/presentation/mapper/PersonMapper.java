package org.contactcentre.presentation.mapper;

import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.domain.model.client.Child;
import org.contactcentre.domain.model.client.Parent;
import org.contactcentre.presentation.dto.ChildDto;
import org.contactcentre.presentation.dto.ParentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ParentMapper.class, ChildMapper.class, AddressMapper.class})
public interface PersonMapper {
    Child toChild(ChildDto childDto) throws PersonalDetailException, DateOfBirthException, AddressException;

    Parent toParent(ParentDto parentDto) throws TitleException, PersonalDetailException, AddressException;
}
