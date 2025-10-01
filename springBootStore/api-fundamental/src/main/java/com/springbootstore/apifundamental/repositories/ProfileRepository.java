package com.springbootstore.apifundamental.repositories;

import com.springbootstore.apifundamental.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile,Long> {
}
