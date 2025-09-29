package com.springbootstore.store.services;

import com.springbootstore.store.Dtos.ProfileDto;
import com.springbootstore.store.entities.Profile;
import com.springbootstore.store.repositories.ProfileRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProfileService {
    private ProfileRepository profileRepository;

    @Transactional
    public Iterable<Long> getProfileIdsByLoyaltyPoints(int loyaltyPoints) {
        return profileRepository.findProfileIdsByLoyaltyPoints(loyaltyPoints);
    }

    @Transactional
    public Iterable<ProfileDto> getProfileIdsAndUserEmailsByLoyaltyPoints(int loyaltyPoints) {
        return profileRepository.findProfileIdsAndUserEmailsByLoyaltyPoints(loyaltyPoints);
    }

    @Transactional
    public Iterable<String> getSortedProfileIdsAndUserEmails(int loyaltyPoints) {
        return profileRepository.findSortedProfileOrderByUserEmail(loyaltyPoints);
    }
}
