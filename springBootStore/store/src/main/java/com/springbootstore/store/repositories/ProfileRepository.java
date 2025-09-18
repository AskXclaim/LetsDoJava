package com.springbootstore.store.repositories;

import com.springbootstore.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Profile findFirstBy();
}
