package org.contactcentre.domain.model.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.contactcentre.domain.contract.Addressable;
import org.contactcentre.domain.contract.entity.Person;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.model.Address;
import org.contactcentre.shared.Gender;

import java.time.LocalDate;

@Getter
@ToString(callSuper = true)
public class Child extends Person implements Addressable {
    private final Gender genderAtBirth;
    private final LocalDate dateOfBirth;
    private final Address address;
    @Setter
    private String fatherId;
    @Setter
    private String motherId;

    @Builder
    public Child(String id, String firstName, String middleName, String lastName, Gender gender,
                 Gender genderAtBirth, LocalDate dateOfBirth, Address address, String fatherId, String motherId)
            throws PersonalDetailException, DateOfBirthException {
        super(id, firstName, middleName, lastName, gender);

        this.genderAtBirth = genderAtBirth;
        this.address = address;
        this.fatherId = fatherId;
        this.motherId = motherId;
        validateDateOfBirth(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    private void validateDateOfBirth(LocalDate dateOfBirth) throws DateOfBirthException{
        if (dateOfBirth == null)
            throw new DateOfBirthException("Date of birth cannot be null");
        if (dateOfBirth.isAfter(LocalDate.now()))
            throw new DateOfBirthException("Date of birth cannot be in the future");
    }

    @Override
    public Address getAddress() {
        return address;
    }
}
