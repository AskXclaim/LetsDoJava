package org.contactcentre.application.command;

import lombok.Builder;
import org.contactcentre.shared.Gender;
import org.contactcentre.shared.Title;

@Builder
public record ParentCommand(Title title, String firstName, String middleName, String lastName, Gender gender,
                            AddressCommand address, String phoneNumber, String email) {
}
