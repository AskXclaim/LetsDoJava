package com.springbootstore.apifundamental.repositories;

import com.springbootstore.apifundamental.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
