package org.contactcentre.domain.contract;

import lombok.*;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.shared.Gender;

import static org.contactcentre.shared.StringUtility.cleanValue;

@Getter
@ToString
public abstract class Client {
    private final Long id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final Gender gender;

    public Client(Long id, String firstName, String middleName, String lastName, Gender gender) throws PersonalDetailException {
        this.id = id;
        validateName(firstName, "first name");
        this.firstName = cleanValue(firstName);
        this.middleName = cleanValue(middleName);
        validateName(lastName, "last name");
        this.lastName = cleanValue(lastName);
        this.gender = gender;
    }

    private void validateName(String fieldValue, String fieldName) throws PersonalDetailException {
        if (fieldValue == null || fieldValue.isEmpty()) {
            throw new PersonalDetailException(fieldName + " cannot be null or empty");
        }
    }
}
