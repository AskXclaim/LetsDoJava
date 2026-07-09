package org.contactcentre.infrastructure.persistence;

import org.contactcentre.domain.contract.repository.ClientRepository;
import org.contactcentre.domain.model.client.Parent;
import org.springframework.stereotype.Service;

@Service
public class ParentClientRepository implements ClientRepository<Parent> {
    @Override
    public long add(Parent client) {
        return 0;
    }
}
