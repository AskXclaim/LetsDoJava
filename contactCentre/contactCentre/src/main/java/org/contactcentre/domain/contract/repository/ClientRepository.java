package org.contactcentre.domain.contract.repository;

import org.contactcentre.domain.contract.entity.Person;


public interface ClientRepository<T extends Person> {
    String add(T client);

    Iterable<T> getByName(String name);
}
