package org.contactcentre.presentation.api.dto;

import lombok.Builder;
import org.contactcentre.shared.Gender;
import org.contactcentre.shared.Title;

@Builder
public record ParentDto(Long id, Title title, String firstName, String middleName, String lastName, Gender gender,
                        AddressDto address) {
}
