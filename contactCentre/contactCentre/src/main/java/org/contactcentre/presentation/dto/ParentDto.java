package org.contactcentre.presentation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.NonNull;
import org.contactcentre.shared.Gender;
import org.contactcentre.shared.Title;
import org.contactcentre.shared.validation.phone.Phone;

@Builder
public record ParentDto(
        @NonNull Title title,
        @NotBlank @Min(2) String firstName,
        @Min(1) String middleName,
        @NotBlank @Min(2) String lastName,
        @NotNull Gender gender,
        @NotNull AddressDto address, @Phone String phone, @Email String email) {
}
