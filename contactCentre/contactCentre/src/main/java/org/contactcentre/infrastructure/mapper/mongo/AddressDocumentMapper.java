package org.contactcentre.infrastructure.mapper.mongo;

import org.contactcentre.domain.model.Address;
import org.contactcentre.infrastructure.model.mongo.AddressDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressDocumentMapper {
    AddressDocument toAddressDocument(Address address);
}
