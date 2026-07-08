package org.contactcentre.domain.contract;

import lombok.*;
import org.contactcentre.domain.exception.NameException;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public abstract class Client {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;

    public void setFirstName(String firstName) throws NameException {
        if (isNameValid(firstName)) {
            this.firstName = firstName;
            return;
        }

        throw new NameException("First name cannot be null or empty");
    }

    public void setLastName(String lastName) throws NameException {
        if (isNameValid(lastName)) {
            this.lastName = lastName;
            return;
        }

        throw new NameException("last name cannot be null or empty");
    }

    private boolean isNameValid(String name) {
        return name != null && !name.isEmpty();
    }
}
