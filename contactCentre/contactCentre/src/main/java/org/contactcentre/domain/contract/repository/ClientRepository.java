package org.contactcentre.domain.contract.repository;

import org.contactcentre.domain.contract.Client;


public interface ClientRepository<T extends Client> {
    long add(T client);
}
