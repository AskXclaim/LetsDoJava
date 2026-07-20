package org.contactcentre.presentation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AddressDto(@NotBlank String addressLineOne,
                         @Min(3) String addressLineTwo,
                         @NotBlank @Min(2) String city,
                         @Min(3) String county,
                         @NotBlank @Min(2) String country,
                         @NotBlank @Min(4) String postCode) {
}
