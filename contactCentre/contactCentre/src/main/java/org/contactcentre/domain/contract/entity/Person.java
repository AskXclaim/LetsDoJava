package org.contactcentre.domain.contract.entity;

import lombok.Getter;
import lombok.ToString;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.shared.Gender;

import static org.contactcentre.shared.StringUtility.cleanValue;

@Getter
@ToString
public abstract class Person extends Entity {
    private final String id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final Gender gender;

    public Person(String id, String firstName, String middleName, String lastName, Gender gender) throws PersonalDetailException {
        this.id = id;
        validateName(firstName, "first type");
        this.firstName = cleanValue(firstName);
        this.middleName = cleanValue(middleName);
        validateName(lastName, "last type");
        this.lastName = cleanValue(lastName);
        this.gender = gender;
    }

    private void validateName(String fieldValue, String fieldName) throws PersonalDetailException {
        if (fieldValue == null || fieldValue.isEmpty()) {
            throw new PersonalDetailException(fieldName + " cannot be null or empty");
        }
    }

}
