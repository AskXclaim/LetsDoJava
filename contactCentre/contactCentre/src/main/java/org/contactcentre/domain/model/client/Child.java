package org.contactcentre.domain.model.client;

import lombok.Getter;
import lombok.ToString;
import org.contactcentre.domain.contract.Client;
import org.contactcentre.domain.exception.DateOfBirthException;

import java.time.LocalDate;

@Getter
@ToString(callSuper = true)
public class Child extends Client {
    private final String genderAtBirth;
    private LocalDate dateOfBirth;

    public Child(Long id, String firstName, String middleName, String lastName, String gender,
                 String genderAtBirth, LocalDate dateOfBirth) throws DateOfBirthException {
        super(id, firstName, middleName, lastName, gender);

        this.genderAtBirth = genderAtBirth;

        validateDateOfBirth(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws DateOfBirthException {
        validateDateOfBirth(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    private  void validateDateOfBirth(LocalDate dateOfBirth) throws DateOfBirthException {
        if (dateOfBirth == null)
            throw new DateOfBirthException("Date of birth cannot be null");
        if (dateOfBirth.isAfter(LocalDate.now()))
            throw new DateOfBirthException("Date of birth cannot be in the future");
    }
}
