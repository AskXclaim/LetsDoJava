package org.contactcentre.presentation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.contactcentre.shared.Gender;

import java.time.LocalDate;

@Builder
public record ChildDto(
        @NotBlank @Min(2) String firstName,
        @Min(1) String middleName,
        @NotBlank @Min(2) String lastName,
        @NotNull Gender gender,
        @NotNull Gender genderAtBirth,
        @NotNull LocalDate dateOfBirth,
        @NotNull AddressDto address) {
}
