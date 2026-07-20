package org.contactcentre.infrastructure.persistence.mongo.contract;

import org.contactcentre.infrastructure.model.mongo.ChildDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChildMongoRepository extends MongoRepository<ChildDocument, String> {
}

