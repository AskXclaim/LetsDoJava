package org.contactcentre.infrastructure.persistence;

import org.contactcentre.domain.contract.repository.ClientRepository;
import org.contactcentre.domain.model.client.Child;
import org.springframework.stereotype.Service;

@Service
public class ChildClientRepository implements ClientRepository<Child> {
    @Override
    public long add(Child client) {
        return 0;
    }

    @Override
    public Iterable<Child> getByName() {
        return null;
    }
}
