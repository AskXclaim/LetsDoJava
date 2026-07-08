package org.contactcentre.presentation.api.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ChildDto(Long id, String firstName, String middleName, String lastName, String gender,
                       String genderAtBirth, LocalDate dateOfBirth) {
}
