package com.springbootstore.store.repositories;

import com.springbootstore.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
