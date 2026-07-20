package org.contactcentre.infrastructure.persistence.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.contactcentre.domain.contract.repository.ClientRepository;
import org.contactcentre.domain.model.client.Parent;
import org.contactcentre.infrastructure.mapper.mongo.ParentDocumentMapper;
import org.contactcentre.infrastructure.model.mongo.ParentDocument;
import org.contactcentre.infrastructure.persistence.mongo.contract.ParentMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Builder
public class ParentClientRepository implements ClientRepository<Parent> {
    private final ParentMongoRepository mongoRepository;
    private final ParentDocumentMapper mapper;

    @Override
    public String add(Parent client) {
        ParentDocument savedParent = mongoRepository.save(mapper.toParentDocument(client));
        return savedParent.getId().toString();
    }

    @Override
    public Iterable<Parent> getByName(String name) {
       var parentDocuments = mongoRepository.findByName(name);

        return parentDocuments.stream().map(mapper::toParent).toList();
    }
}
