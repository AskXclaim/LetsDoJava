package com.springbootstore.store.repositories;

import com.springbootstore.store.Dtos.ProfileDto;
import com.springbootstore.store.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Profile findFirstBy();

    @Query("SELECT p.id FROM Profile p WHERE p.loyaltyPoints > :loyaltyPoints")
    Iterable<Long> findProfileIdsByLoyaltyPoints(int loyaltyPoints);

    @EntityGraph(attributePaths = "user")
    @Query("SELECT  p.id  AS id, p.user.email AS email FROM Profile p JOIN User u ON p.user.id = u.id WHERE p.loyaltyPoints > :loyaltyPoints")
    Iterable<ProfileDto> findProfileIdsAndUserEmailsByLoyaltyPoints(int loyaltyPoints);

    @EntityGraph(attributePaths = "user")
    Iterable<String> findSortedProfileOrderByUserEmail(int loyaltyPoints);

}
