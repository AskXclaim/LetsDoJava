package org.contactcentre.infrastructure.persistence.mongo.contract;

import org.contactcentre.infrastructure.model.mongo.ParentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ParentMongoRepository extends MongoRepository<ParentDocument, String> {
    @Query("""
            {
              '$or': [
                { 'firstName': { '$regex': ?0, '$options': 'i' } },
                { 'middleName': { '$regex': ?0, '$options': 'i' } },
                { 'lastName': { '$regex': ?0, '$options': 'i' } }
              ]
            }
            """)
    List<ParentDocument> findByName(String name);
}
