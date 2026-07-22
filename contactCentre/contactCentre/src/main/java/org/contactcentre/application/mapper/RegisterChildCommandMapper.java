package org.contactcentre.application.mapper;

import org.contactcentre.application.command.AddressCommand;
import org.contactcentre.application.command.ChildCommand;
import org.contactcentre.application.command.ParentCommand;
import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.model.Address;
import org.contactcentre.domain.model.client.Child;
import org.contactcentre.domain.model.client.Parent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegisterChildCommandMapper {
    Address toAddress(AddressCommand addressCommand) throws AddressException;
    Child toChild(ChildCommand childCommand) throws PersonalDetailException, DateOfBirthException;
    @Mapping(source = "phoneNumber", target = "phone")
    Parent toParent(ParentCommand parentCommand) throws PersonalDetailException;
}
