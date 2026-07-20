package org.contactcentre.infrastructure.mapper.mongo;

import org.contactcentre.domain.model.client.Child;
import org.contactcentre.domain.model.client.Parent;
import org.contactcentre.infrastructure.model.mongo.ChildDocument;
import org.contactcentre.infrastructure.model.mongo.ParentDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ParentDocumentMapper.class, ChildDocumentMapper.class})
public interface RegisterChildMapper {
    ChildDocument toChildDocument(Child child);
    ParentDocument toParentDocument(Parent parent);
}
