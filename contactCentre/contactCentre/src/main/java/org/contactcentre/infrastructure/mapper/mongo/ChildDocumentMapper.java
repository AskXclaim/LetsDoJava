package org.contactcentre.infrastructure.mapper.mongo;

import org.contactcentre.domain.model.client.Child;
import org.contactcentre.infrastructure.model.mongo.ChildDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {AddressDocumentMapper.class})
public interface ChildDocumentMapper {
    @Mapping(target = "fatherId", source = "fatherId")
    @Mapping(target = "motherId", source = "motherId")
    ChildDocument toChildDocument(Child child);
}
