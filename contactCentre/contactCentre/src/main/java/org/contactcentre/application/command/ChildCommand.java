package org.contactcentre.application.command;

import lombok.Builder;
import org.contactcentre.shared.Gender;

import java.time.LocalDate;

@Builder
public record ChildCommand(String firstName, String middleName, String lastName, LocalDate dateOfBirth, Gender gender,
                           Gender genderAtBirth, AddressCommand address) {
}
