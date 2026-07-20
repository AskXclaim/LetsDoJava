package org.contactcentre.infrastructure.persistence.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.contactcentre.domain.contract.repository.ClientRepository;
import org.contactcentre.domain.model.client.Child;
import org.contactcentre.infrastructure.mapper.mongo.ChildDocumentMapper;
import org.contactcentre.infrastructure.model.mongo.ChildDocument;
import org.contactcentre.infrastructure.persistence.mongo.contract.ChildMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Builder
public class ChildClientRepository implements ClientRepository<Child> {
    private final ChildMongoRepository mongoRepository;
    private final ChildDocumentMapper mapper;

    @Override
    public String add(Child client) {
        ChildDocument savedChild = mongoRepository.save(mapper.toChildDocument(client));
        return savedChild.getId();
    }

    @Override
    public Iterable<Child> getByName(String name) {
        return List.of();
    }
}