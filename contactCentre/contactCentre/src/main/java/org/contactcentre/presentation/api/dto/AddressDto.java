package org.contactcentre.presentation.api.dto;

import lombok.Builder;

@Builder
public record AddressDto(String addressLineOne, String addressLineTwo, String city, String county, String country,
                         String postCode) {
}
