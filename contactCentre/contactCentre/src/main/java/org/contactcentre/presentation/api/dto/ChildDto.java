package org.contactcentre.presentation.api.dto;

import lombok.Builder;
import org.contactcentre.shared.Gender;

import java.time.LocalDate;

@Builder
public record ChildDto(Long id, String firstName, String middleName, String lastName, Gender gender,
                       String genderAtBirth, LocalDate dateOfBirth, AddressDto address) {
}
